package day18;
/*
 Создайте рекурсивный метод, который принимает на вход единственный аргумент - число,
и возвращает количество цифр 7 в этом числе. Циклы использовать запрещено, можно
использовать только рекурсивные вызовы.

Пример:
System.out.println(count7(717771237)); // 5
* */
public class Task2 {
    private static int num;
    public static void main(String[] args) {
        long a = 4970728437798756L;
        System.out.println(count7(a));
    }
    public static int count7(long n) {
        if(n == 0) { return num;}
        if(n % 10 == 7) { num++; }
        return count7(n / 10);
    }
}
