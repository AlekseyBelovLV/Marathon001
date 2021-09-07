package day8;

public class Task2 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("CESSNA 172", 2019, 8, 736);
        System.out.println(airplane1);
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

    public String toString() {
        return producer + ", " + year + ", " + length + ", " + weight + ".";
    }
}

