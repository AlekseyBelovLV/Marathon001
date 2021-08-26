package day4;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    private static final Random RND = new Random();
    private static final int[] ARR = new int[100];
    private static final int[] infoArr = new int[4];


    public static void main(String[] args) {
        fillArr();
        createInfoArr();
        showInfoArr();
    }

    private static void fillArr() {
        for(int i = 0; i < ARR.length; i++) {
            ARR[i] = RND.nextInt(1000)+1;
        }
    }

    private static void createInfoArr() {
        infoArr[1] = ARR[0];
        for(int i = 0; i < ARR.length; i++) {
            if(ARR[i] > infoArr[0]) infoArr[0] = ARR[i];
            if(ARR[i] < infoArr[1]) infoArr[1] = ARR[i];
            if(ARR[i] % 10 == 0) infoArr[2]++;
            if(ARR[i] % 10 == 0) infoArr[3] += ARR[i];
        }
    }

    private static void showInfoArr() {
        System.out.println(Arrays.toString(ARR));
        System.out.println("Наибольший элемент массива: " + infoArr[0]);
        System.out.println("Наименьший элемент массива: " + infoArr[1]);
        System.out.println("Количество элементов массива, оканчивающихся на 0: " + infoArr[2]);
        System.out.println("Сумма элементов массива, оканчивающихся на 0: " + infoArr[3]);
    }
}
