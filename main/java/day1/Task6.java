package day1;

public class Task6 {
    public static void main(String[] args) {
//        int k = 3;
        showMultiplicationTable(3);
    }
    private static void showMultiplicationTable(int number) {
        for(int i = 1; i < 10; i++) {
            System.out.println(i + " x " + number + " = " + i * number);
        }
    }
}
