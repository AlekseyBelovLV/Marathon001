package day1;

public class Task4 {
    public static void main(String[] args) {
        showYear(1980, 2020, 4);
    }
    private static void showYear(int beginning, int end, int cycle) {
        while(beginning <= end) {
            System.out.println("Олимпиада " + beginning + " года");
            beginning += cycle;
        }
    }
}
