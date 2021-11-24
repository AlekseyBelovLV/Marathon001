package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static FileWriter fw;
    public static Scanner scn;
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        try {
            if(!file1.isFile()) { file1.createNewFile(); }
            if(!file2.isFile()) { file2.createNewFile(); }
            fillFile(file1);
            averageNum(file1, file2);
            printResult(file2);
        } catch (IOException e) {
            System.out.println("Что-то пошло не так :О");;
        }
    }

    public static void fillFile(File file) throws IOException {
        Random rnd = new Random();
        fw = new FileWriter(file, false);
        for(int i = 0; i < 1000; i++) {
            fw.write((rnd.nextInt(100) +1) +";");
        }
        fw.flush();
    }

    public static void averageNum(File file1, File file2) throws IOException {
        scn = new Scanner(file1);
        fw = new FileWriter(file2);

        String[] str = scn.nextLine().split(";");
        float[] num = new float[str.length];
        for(int i = 0; i < str.length; i++) {
            num[i] = Float.parseFloat(str[i]);
        }

        float tempSum = 0F;
        for (int i = 0; i < num.length; i++) {
            tempSum += num[i];
            if((i+1) % 20 == 0) {
                fw.write((tempSum / 20) + " ");
                tempSum = 0F;
            }
        }
        scn.close();
        fw.flush();
    }

    public static void printResult(File file) throws FileNotFoundException {
        scn = new Scanner(file);
        float sum = 0F;
        String[] str = scn.nextLine().split(" ");
        for (String i: str) { sum += Float.parseFloat(i); }
        System.out.println("Ответ: " + ((int)sum));
        scn.close();
    }

}
