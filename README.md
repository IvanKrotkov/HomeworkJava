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



















