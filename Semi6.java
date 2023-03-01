import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Semi5 {
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

    static String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append(" - ");
                        break;
                    case -1:
                        sb.append("|:|");
                        break;
                    case -2:
                        sb.append("< >");
                        break;
                    case -3:
                        sb.append("0+0");
                        break;
                    default:
                        break;
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] map[] = getMap();
//        System.out.println(mapColor(map));
        int[] st = searchPosition(map, -3);
        wave(map, st);
        System.out.println(rawData(map));
//        System.out.println(mapColor(map));
    }

    static int[] searchPosition(int[][] map, int index) { // index - "-3" - точка начала;"-2" - точка выхода
        int[] coordinate = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == index) {
                    coordinate[0] = i;
                    coordinate[1] = j;
                }
            }
        }
        return coordinate;
    }

    static void print(Queue<int[]> arr) {
        for (int[] item : arr) {
            System.out.println("_____");
            System.out.println(Arrays.toString(item));
            System.out.println("-----");
        }
    }

    static void fillAr(int[] arr, int x, int y) {
        arr[0] = x;
        arr[1] = y;
    }

    static void wave(int[][] map, int[] start) {
        int[] temp1 = new int[2];
        int[] temp2 = new int[2];
        int[] temp3 = new int[2];
        int[] temp4 = new int[2];
        Queue<int[]> res = new LinkedList<>();
        int count = 0;
        res.add(start);
        while (res.size() > 0) {
            count++;
            print(res);
            int[] coordinate = res.remove();
            int x = coordinate[0];
            int y = coordinate[1];
            if (Arrays.equals(coordinate, start)) {
                map[x][y] = 1;
            }
            if (map[x - 1][y] == 0) {
                temp1[0] = x - 1;
                temp1[1] = y;
                res.add(temp1);
                System.out.println(Arrays.toString(temp1));
                map[x - 1][y] = map[x][y] + 1;
            }
            if (map[x][y + 1] == 0) {
                fillAr(temp2, x, (y + 1));
                res.add(temp2);
                System.out.println(Arrays.toString(temp2));
                map[x][y + 1] = map[x][y] + 1;
            }
            if (map[x + 1][y] == 0) {
                fillAr(temp3, (x + 1), y);
                res.add(temp3);
                System.out.println(Arrays.toString(temp3));
                map[x + 1][y] = map[x][y] + 1;

            }
            if (map[x][y - 1] == 0) {
                fillAr(temp4, x, (y - 1));
                res.add(temp4);
                System.out.println(Arrays.toString(temp4));
                map[x][y - 1] = map[x][y] + 1;
            }
            print(res);
        }
    }
}
