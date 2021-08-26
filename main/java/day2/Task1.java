package day2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int myIn = scn.nextInt();
        if(myIn > 0 && myIn< 5) {
            System.out.println("Малоэтажное здание");
        } else if (myIn > 4 && myIn < 9) {
            System.out.println("Среднеэтажное здание.");
        } else if (myIn >  8) {
            System.out.println("Многоэтажный дом.");
        } else if (myIn < 0) {
            System.out.println("Ошибка ввода");
        } else {
            System.out.println("Это не цифра.");
        }
        scn.close();
    }
}
