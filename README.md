# Домашняя работа 
## Задание первого семинара
*Написать программу вычисления n-ого треугольного числа.*
1. Есть число
   
2. Метод вычисления треугольного числа
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