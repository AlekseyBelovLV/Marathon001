package day15;

import day14.ScannerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    private static Scanner scn;
    public static void main(String[] args) {
        File file = new File("main/resources/shoes.csv");

        try{
            missingShoes(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (NumberFormatException e) {
            System.out.println("Неправельный формат файла.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ScannerException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void missingShoes(File file) throws IOException, ScannerException {
        if(fileIsCorrect(file)) {
            File file2 = new File("main/resources/missing_shoes.txt");
            if(!file2.isFile()) { file2.createNewFile(); }

            scn = new Scanner(file);
            FileWriter fw = new FileWriter("main/resources/missing_shoes.txt", false);

            while (scn.hasNextLine()) {
                String[] strArr = scn.nextLine().split(";");
                if (Integer.parseInt(strArr[2]) == 0) {
                    for (int i = 0; i < strArr.length; i++) {
                        fw.write(strArr[i] + ", ");
                    }
                    fw.write("\n");
                }
            }
            fw.flush();
            scn.close();
        }
    }

    private static boolean fileIsCorrect(File file) throws FileNotFoundException, ScannerException {
        scn = new Scanner(file);
        if(!scn.hasNextLine()) {
            throw new ScannerException("Файл пустой.");
        }

        while(scn.hasNextLine()) {
            String[] strArr2 = scn.nextLine().split(";");
            if(strArr2.length != 3) {
                throw new ScannerException("Не корректное отображение информации.");
            }
        }
        return true;
    }
}
