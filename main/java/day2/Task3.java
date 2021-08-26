package day2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();
        int counter = a;
        while(counter < b) {
            if(counter % 5 == 0 && counter % 10 != 0) {
                System.out.print(counter + " ");
            }
            counter++;
        }
    }
}
