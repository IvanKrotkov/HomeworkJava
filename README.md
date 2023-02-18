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


























