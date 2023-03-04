import java.util.*;

public class Semi6 {
    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        static boolean belongingToTheMap(int[][] map, Coordinate ex) {
            if (ex.x < 0 & ex.y < 0 | ex.x > map.length & ex.y > map[0].length) return false;
            else return true;
        }
    }
    static class MapCreater {
            static int[][] createEmptyMap(int rows, int columns) {
            return new int[rows][columns];
        }
        static int[][] getMap() {
            return new int[][]{
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1, 00, -1, -1, -1, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1},
                    {-1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -3, 00, 00, 00, 00, 00, 00, 00, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
            };
        }
        private static void createOutlineMap(int[][] map) {
            for (int i = 0; i < map[0].length; i++) {
                map[0][i] = -1;
                map[map.length - 1][i] = -1;
            }
            for (int i = 0; i < map.length; i++) {
                map[i][0] = -1;
                map[i][map[i].length - 1] = -1;
            }
        }

        private static void createWall(int[][] map) {
            int row = new Random().nextInt(2, map.length);
            int column = new Random().nextInt(3, map[0].length);
            for (int i = row; i < map.length - 4; i++) {
                map[i][column] = -1;
            }
            for (int i = column; i < map[0].length - 4; i++) {
                map[row][i] = -1;
            }
        }

        static int[][] getRandomMap(int rows, int columns) {
            int[] map[] = createEmptyMap(rows, columns);
            createOutlineMap(map);
            createWall(map);
            createWall(map);
            createWall(map);
            return map;
        }

        static void printMap(int[][] map) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.printf("%5d", map[i][j]);
                }
                System.out.println();
            }
        }
        static void printSolution(int[][] map,Coordinate st,Coordinate ex){
            Queue<Coordinate> sol = AlgorithmLi.searchSolution(map,st,ex);
            while (sol.size() != 0){
                Coordinate step = sol.remove();
                map[step.x][step.y] = 0;
            }
            printMap(map);
        }
        static void setStart(int[][] map, Coordinate st) {
            if (Coordinate.belongingToTheMap(map, st)) map[st.x][st.y] = -3;
            else return;
        }
        static void setExit(int[][] map, Coordinate ex) {
            if (Coordinate.belongingToTheMap(map, ex)) {
                map[ex.x][ex.y] = -2;
            } else return;
        }
        public class AlgorithmLi {
            static Queue<Coordinate> searchSolution(int[][] map, Coordinate st, Coordinate ex) {
                Queue<Coordinate> sol = new LinkedList<>();
                Coordinate step = ex;
                sol.add(step);
                while (map[step.x][step.y] != map[st.x][st.y]) {
                    if (map[step.x - 1][step.y] == map[step.x][step.y] - 1) {
                        step = new Coordinate(step.x - 1, step.y);
                        sol.add(step);
                    } else if (map[step.x][step.y - 1] == map[step.x][step.y] - 1) {
                        step = new Coordinate(step.x, step.y - 1);
                        sol.add(step);
                    } else if (map[step.x + 1][step.y] == map[step.x][step.y] - 1) {
                        step = new Coordinate(step.x + 1, step.y);
                        sol.add(step);
                    } else if (map[step.x][step.y + 1] == map[step.x][step.y] - 1) {
                        step = new Coordinate(step.x, step.y + 1);
                        sol.add(step);
                    }
                }
                return sol;
            }
            static void wave(int[][] map, Coordinate st) {
                Queue<Coordinate> res = new LinkedList<>();
                map[st.x][st.y] = 1;
                res.add(st);
                while (res.size() > 0) {
                    Coordinate step = res.remove();
                    int x = step.x;
                    int y = step.y;
                    if (map[x - 1][y] == 0) {
                        res.add(new Coordinate(x - 1, y));
                        map[x - 1][y] = map[x][y] + 1;
                    }
                    if (map[x][y - 1] == 0) {
                        res.add(new Coordinate(x, y - 1));
                        map[x][y - 1] = map[x][y] + 1;
                    }
                    if (map[x + 1][y] == 0) {
                        res.add(new Coordinate(x + 1, y));
                        map[x + 1][y] = map[x][y] + 1;
                    }
                    if (map[x][y + 1] == 0) {
                        res.add(new Coordinate(x, y + 1));
                        map[x][y + 1] = map[x][y] + 1;
                    }
                }
            }
        }
        public static void main(String[] args) {
            int[] map[] = MapCreater.getRandomMap(10, 20);
            Coordinate exit = new Coordinate(8, 10);
            Coordinate start = new Coordinate(6, 2);
            MapCreater.setStart(map, start);
            AlgorithmLi.wave(map, start);
            MapCreater.printMap(map);
            System.out.println("--");
            MapCreater.printSolution(map,start,exit);
        }
    }
}