package day4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    private static final Random RND = new Random();
    private static int[] arr = new int[20];

    public static void main(String[] args) {
        arrFill();
        maxForThree();
    }

    private static void arrFill() {
        for (int i = 0; i < arr.length; i++) {
                arr[i] = RND.nextInt(10000) +1;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void maxForThree() {
        int sum = 0;
        int maxSum = 0;
        int indexNum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i+2 < arr.length) {
                for (int j = i; j < i + 3; j++) {
                    sum += arr[j];
                }
            }
            if(sum > maxSum) {
                maxSum = sum;
                indexNum = i + 1;
            }
            sum = 0;
        }
        System.out.println(indexNum + " " + maxSum);
    }
}