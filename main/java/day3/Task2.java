package day3;

import java.util.Scanner;

public class Task2 {
    private static final Scanner SCN = new Scanner(System.in);

    public static void main(String[] args) {
        programWorked();
    }

    private static void programWorked() {
        while (true) {
            double first = humanIn();
            double second = humanIn();
            if(second == 0)  break;
            System.out.println(first / second);
        }
        SCN.close();
    }

    private static double humanIn() {
        return SCN.nextDouble();
    }
}
