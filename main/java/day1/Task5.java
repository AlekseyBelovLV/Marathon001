package day1;

public class Task5 {
    public static void main(String[] args) {
        showYear(1980, 2020, 4);
    }
    private static void showYear(int beginning, int end, int cycle) {
        for(int i = beginning; i <= end; i++) {
            if(i % cycle == 0) System.out.println("Олимпиада " + i + " года");
        }
    }
}
