package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    private static Scanner scn;

    public static void main(String[] args) {
        File file = new File("people");
        try{
//            scn = new Scanner(file);
            System.out.println(parseFileToStringList(file));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }

    public static List<String> parseFileToStringList(File file) throws FileNotFoundException {
        List<String> names = new ArrayList();
        if(fileIsCorrect(file)) {
            scn = new Scanner(file);
            while (scn.hasNextLine()) {
                names.add(scn.nextLine());
            }
        }
        scn.close();
        return names;
    }

    private static boolean fileIsCorrect(File file) throws FileNotFoundException {
        scn = new Scanner(file);
        while(scn.hasNextLine()) {
            String line = scn.nextLine();
            String[] tempWords = line.split(" ");
            int tempNum = Integer.parseInt(tempWords[1]);
            if(tempNum < 0) {
                try {
                    throw new ScannerException();
                } catch (ScannerException e) {
                    System.out.println("Некорректный входной файл");
                }
                return false;
            }
        }
        return true;
    }
}
