package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static Scanner scn;
    public static void main(String[] args) {
        File file = new File("people.txt");

        System.out.println(parseFileToStringList(file));
    }

    public static List<String> parseFileToStringList(File file) {
        List<String> nameAndAge = new ArrayList<>();
        try {
            if(fileIsCorrect(file)) {
                scn = new Scanner(file);
                while (scn.hasNextLine()) {
                    nameAndAge.add(scn.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ScannerException e) {
            System.out.println("Некорректный входной файл.");
        }
        scn.close();
        return nameAndAge;
    }

    private static boolean fileIsCorrect(File file) throws FileNotFoundException, ScannerException{
        scn = new Scanner(file);
        while(scn.hasNextLine()) {
            String[] str = scn.nextLine().split(" ");
            if (Integer.parseInt(str[1]) < 0) { throw new ScannerException(); }
        }
        return true;
    }
}
