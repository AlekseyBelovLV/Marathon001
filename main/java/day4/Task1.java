package day4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    private static final Random RND = new Random();
    private static final Scanner SCN = new Scanner(System.in);

    private static int [] arr;
    private static final int [] infoArr = new  int[6];

    public static void main(String[] args) {
        infoArr[0] = SCN.nextInt();
        createArr();
        getInfoArr();
        showInfoArr();

        SCN.close();
    }

    private static void createArr() {
        arr = new int[infoArr[0]];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RND.nextInt(infoArr[0]) + 1;
        }
    }

    private static void getInfoArr() {
        for (int i : arr) {
            if (arr[i] > 8) infoArr[1]++;
            if (arr[i] == 1) infoArr[2]++;
            if (arr[i] % 2 == 0) infoArr[3]++;
            if (arr[i] % 2 != 0) infoArr[4]++;
            infoArr[5] += arr[i];
        }
    }

    private static void showInfoArr() {
        System.out.println(Arrays.toString(arr));
        System.out.println("Длинна массива: " + infoArr[0]);
        System.out.println("Колличество чисел больше 8: " + infoArr[1]);
        System.out.println("Колличество чисел равных 1: " + infoArr[2]);
        System.out.println("Колличество чётных чисел: " + infoArr[3]);
        System.out.println("Колличество не чётных чисел: " + infoArr[4]);
        System.out.println("Сумма всех чисел массива чисел: " + infoArr[5]);

        System.out.println(Arrays.toString(infoArr));
    }
}
