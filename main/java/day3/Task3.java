package day3;

import java.util.Scanner;

public class Task3 {
    private static final Scanner SCN = new Scanner(System.in);
    public static void main(String[] args) {
        checkAndCalculate();
    }
    private static void checkAndCalculate() {
        for(int i = 0; i < 5; i++) {
           double first = humanIn();
           double second = humanIn();
           if(second == 0) {
               showResult("Деление на ноль.");
               continue;
           }
           double b = first / second;
           String str = String.valueOf(b);
           showResult(str);
        }
    }
    private static void showResult(String a) {
        System.out.println(a);
    }

    private static double humanIn() {
        return SCN.nextDouble();
    }
}
