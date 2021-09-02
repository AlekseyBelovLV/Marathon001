package day7;

public class Task1 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Cessna 172", 2001, 8, 736);
        Airplane airplane2 = new Airplane("Cessna 150", 1977, 7, 504);

        Airplane.compareAirplanes(airplane1.getLength(), airplane2.getLength());
    }
}

class Airplane {
    private String producer;
    private int year;
    private int length;
    private int weight;
    private int fuel = 0;

    public Airplane(String producer, int year, int length, int weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
    }

    public static void compareAirplanes(int a, int b) {
        if(a - b > 0) {
            System.out.println("Первый самолёт больше чем второй.");
        } else if (a - b < 0) {
            System.out.println("Второй самолёт больше чем первый.");
        } else {
            System.out.println("Самолёты одинаковой длины.");
        }
    }
    int getLength() { return length; }

}
