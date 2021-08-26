package day4;

import java.util.Random;

public class Task3 {
    private static final Random RND = new Random();
    private static int[][] matrix = new int[12][8];

    public static void main(String[] args) {
        matrixFill();
        maxSumInLine();
    }

    private static void matrixFill() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = RND.nextInt(51);
            }
        }
    }

    private static void maxSumInLine() {
        int sum = 0;
        int maxSum = 0;
        int numLine = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                sum += matrix[i][j];
            }
            System.out.println(" " + "//" + " сумма - " + sum);
            if (sum >= maxSum) {
                maxSum = sum;
                numLine = i + 1;
            }
            sum = 0;
        }
        System.out.println("Номмер строки " + numLine + ", сумма " + maxSum);
    }
}
