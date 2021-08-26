package day2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();

        for(int i = a; i < b; i++) {
            if(i % 5 == 0 && i % 10 != 0) {
                System.out.print(i + " ");
            }
        }
        scn.close();
    }
}
