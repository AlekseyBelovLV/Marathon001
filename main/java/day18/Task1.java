package day18;
/* Вам дан числовой массив произвольного размера. Посчитайте сумму чисел в
этом массиве не используя циклы (необходимо использовать рекурсивные вызовы).

Пример:
int[] numbers = {1, 10, 1241, 50402, -50, 249, 10215, 665, 2295, 7, 311};
System.out.println(recursionSum(...)); // 65346
* */
public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {1, 10, 1241, 50402, -50, 249, 10215, 665, 2295, 7, 311};
        System.out.println(recursionSum(numbers, numbers.length));
    }
    public static int recursionSum(int[] numbers, int n) {
        if(n == 1) return numbers[n-1];

        return numbers[n-1] + recursionSum(numbers, n - 1);
    }
}
