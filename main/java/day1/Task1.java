package day1;

public class Task1 {
    public static void main(String[] args) {
        showWord("JAVA ", 10);
    }
    private static void showWord(String text, int quantity) {
        int counter = 0;

        while(counter < quantity) {
            System.out.print(text);
            counter++;
        }
    }
}
