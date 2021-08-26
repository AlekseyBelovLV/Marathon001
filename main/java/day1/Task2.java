package day1;

public class Task2 {
    public static void main(String[] args) {
        showWord("JAVA ", 10);
    }
    private static void showWord(String text, int quantity) {
        for(int i = 0; i < quantity; i++) {
            System.out.print(text);
        }
    }
}
