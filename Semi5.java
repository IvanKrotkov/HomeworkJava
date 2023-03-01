import java.util.Random;

public class Semi5 {
    static int[][] createEmptyMap(int rows,int columns){
        return new int[rows][columns];
    }
    static void createOutlineMap(int[][] map){
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = -1;
            map[map.length-1][i] = -1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = -1;
            map[i][map[i].length-1] = -1;
        }
    }
    static void createWall(int[][] map){
        int row = new Random().nextInt(2,map.length);
        int column = new Random().nextInt(3, map[0].length);
        for (int i = row; i < map.length-4; i++) {
                map[i][column] = -1;
        }
        for (int i = column; i < map[0].length-4; i++) {
            map[row][i] = -1;
        }
    }
    static void printMap(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%d\t",map[i][j]);
            }
            System.out.println();
        }
    }
    static int[][] getMap(int rows,int columns){
        int[] map[] = createEmptyMap(rows,columns);
        createOutlineMap(map);
        createWall(map);
        createWall(map);
        createWall(map);
        return map;
    }
    public static void main(String[] args) {
        int[] map[] = getMap(10,15);
        printMap(map);
    }
}
