package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("Day14Task1.txt");
        try {
            printSumDigits(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (ScannerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printSumDigits(File file) throws FileNotFoundException, ScannerException {
        Scanner scn = new Scanner(file);
        String line = scn.nextLine();
        String[] words = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String word : words) { numbers.add(Integer.parseInt(word)); }

        if(numbers.size() != 10) { throw new ScannerException("Некорректный входной файл");}

        int sum = 0;
        for(Integer i:numbers) { sum += i; }
        System.out.println(sum);

        scn.close();
    }
}
