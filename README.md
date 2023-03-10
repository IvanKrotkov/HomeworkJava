# Домашняя работа 
## Задание первого семинара - [url](Semi1.java)
*Написать программу вычисления n-ого треугольного числа.*
1. **Есть число**
   
2. **Метод вычисления треугольного числа**
```Java 
// Метод 
static int TriangularNumber(int value){
    return (value*(value+1))/2;
}
// Результат
public static void main(String[] args) {
        int res = TriangularNumber(8);
        System.out.println(res);
}
```
## Задание второго семинара - [url](Semi2.java)

*Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.*
* *Пример 1: а = 3, b = 2, ответ: 9* 
* *Пример 2: а = 2, b = -2, ответ: 0.25* 
* *Пример 3: а = 3, b = 0, ответ: 1* 
* *Пример 4: а = 0, b = 0, ответ: не определено* 
* *Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt 
1000*
### Задачи
1. **Программа принимает на вход два числа *a,b* в данном случае получает в виде элементов массива, сформировашегося в результате чтения**
2. **Метод возведения в степень**
```Java
static int exponentiation(int a, int b){
        if(b==0) return 1;
        return a*exponentiation(a,b-1);
    }
```
3. **Чтение файла**
```Java
    static String[] fileReading() throws IOException {
        File file = new File("C:/Users/krotk/OneDrive/Рабочий стол/HomeworkJava/Homework_GB/src/input.txt");
        String[] fileReading = Files.readAllLines(file.toPath()).toArray(new String[0]);
        return fileReading;
        }
```
4. **Метод позволяющий "вытащить" из каждой строки файла нужные нам числа**
```Java
static int[] searchDig(String[] arr){
        int[] digital = new int[2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] arrayStr = arr[i].split(" ");
            digital[count] = Integer.parseInt(arrayStr[1]);
            count+=1;
        }
        return digital;
    }
```
5. **Образование нового файла с дальнейшей записью туда результата**
```java
static void writingResult (int res)throws IOException{
        FileWriter file = new FileWriter("output.txt",false);
        file.write(String.format("результат - %d",res));
        file.flush();
    }
```
## Задание третьего семинара - [url](Semi3.java)
*Реализовать алгоритм сортировки слиянием*
1. Один метод рекурсивно делит массив пополам.
```Java
static void mergeSort(int[] input) {
        if (input.length < 2){
            return;
        }
        int len = input.length;
        int[] lefttAr = new int[len/2];
        System.arraycopy(input,0,lefttAr,0,len/2);
        int[] rightAr = new int[len-len/2];
        System.arraycopy(input,len/2 , rightAr,0, len - (len/2));
        mergeSort(lefttAr);
        mergeSort(rightAr);
        merge(input,rightAr,lefttAr);
    }
```
2. Второй метод сравнивает элементы разделённых массивов, наименьший записывает в исходный, до тех пор, 
пока один из массивов не кончится
```Java
static void merge(int[] res, int[] rightAr, int[] lefttAr) {
        int l = 0;
        int r = 0;
        int resUk = 0;
        while (r<rightAr.length & l<lefttAr.length){
            if(rightAr[r] <= lefttAr[l]){
                res[resUk] = rightAr[r];
                r++;
                resUk++;
            } else {
                res[resUk] = lefttAr[l];
                resUk++;
                l++;
            }
        }
        while (r<rightAr.length){
            res[resUk] = rightAr[r];
            r++;
            resUk++;
        }
        while (l<lefttAr.length) {
            res[resUk] = lefttAr[l];
            resUk++;
            l++;
        }

    }
```
# Задача четвёртого семинара - [URL](Semi4.java)
*Реализовать алгоритм пирамидальной сортировки*

1. Построение двоичной кучи с помощью рекурсии
```java
static void createHeap(int[] arr, int len, int index) {
        int max = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < len && arr[left] > arr[max]) {
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            createHeap(arr, len, max);
        }
    }
```
2. Основная функция, выполняющая пирамидальную сортировку
```java
static void sorting(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            createHeap(arr, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            createHeap(arr, i, 0);
        }
    }
```
# Задача пятого семинара - [url](Semi5.java)

*Реализовать механизм печати карты в рамках реализации Волнового алгоритма*
1. Создание пустой карты
```java
static int[][] createEmptyMap(int rows,int columns){
        return new int[rows][columns];
}
```
2. Метод позволяющий сделать контур карты - условно это -1
```java
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
```
3. Метод позволяющий сделать стену на карте 
```java
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
```
4. Метод возвращающий полноценную карту
```java
    static int[][] getMap(int rows,int columns){
        int[] map[] = createEmptyMap(rows,columns);
        createOutlineMap(map);
        createWall(map);
        createWall(map);
        createWall(map);
        return map;
    }
```
5. Метод печати
```java
    static void printMap(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%d\t",map[i][j]);
            }
            System.out.println();
        }
    }
```
# Задача шестого семинара - [URL](Semi6.java)
*Реализовать волновой алгоритм используя классы*
1. Класс Coordinate - класс координат
```Java
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
```
2. Класс MapCreater - все действия с картой 
```Java
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
```
3. Класс выполняющий сам волновой алгоритм 
```Java
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
```


















