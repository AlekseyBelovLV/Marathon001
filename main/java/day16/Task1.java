package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("Day14Task1.txt");
        try {
            System.out.println(printResult(file));
            System.out.printf("%.3f",(printResult(file)));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }

    public static float printResult(File file) throws FileNotFoundException {
        Scanner scn = new Scanner(file);
        String[] str = scn.nextLine().split(" ");
        float result = 0;
        for(String i: str) {
            result += Float.parseFloat(i);
        }
        return result / str.length;
    }
}

