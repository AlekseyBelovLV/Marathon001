package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Cessna 172", 2019, 8, 736);
        airplane1.info();
        airplane1.setYear(2001);
        airplane1.setLength(9);
        airplane1.info();
        airplane1.fuelUp(100);
        airplane1.fuelUp(80);
        airplane1.info();
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

    public void setProducer(String producer) { this.producer = producer; }

    public void setYear(int year) { this.year = year; }

    public void setLength(int length) { this.length = length; }

    public void setWeight(int weight) { this.weight = weight; }

    public void setFuel(int fuel) { this.fuel = fuel; }

    public int getFuel() { return fuel; }

    public void info() { System.out.println("Изготовитель: " + producer +
            ", год выпуска: " + year +
            ", длина: " + length +
            ", вес: " + weight +
            ", количества топлива в баке " + fuel + ".");
    }

    public void fuelUp(int n) { fuel += n;}
}
