package day6;

public class Task1 {
    public static void main(String[] args) {
        Car car1 = new Car("WV golf", "green", 2019);
        Motorbike motorbike1 = new Motorbike("Kawasaki vulcan", "Orange", 2016);

        car1.info();
        motorbike1.info();

        car1.getInfoInCar();
        motorbike1.getInfoInMotorbike();

        System.out.println("Машине " + car1.yearDifference(2021) + " лет.");
        System.out.println("Мотоциклу " + motorbike1.yearDifference(2021) + " лет.");
    }
}
class Motorbike {
    private String model;
    private String color;
    private int yearOfRelease;

    Motorbike(String model, String color, int yearOfRelease) {
        this.model = model;
        this.color = color;
        this.yearOfRelease = yearOfRelease;
    }

    void getInfoInMotorbike() { System.out.println(model + ", " + color + ", " + yearOfRelease); }

    void info() { System.out.println( "Это мотоцикл."); }

    int yearDifference(int inputYear) {
        int year;
        if(inputYear > yearOfRelease) {
            year = inputYear - yearOfRelease;
        } else if (inputYear < yearOfRelease) {
            year = yearOfRelease - inputYear;
        } else {
            year = 0;
        }
        return year;
    }
}
class Car {
    private String model;
    private String color;
    private int yearOfRelease;

    Car(String model, String color, int yearOfRelease) {
        this.model = model;
        this.color = color;
        this.yearOfRelease = yearOfRelease;
    }

    void getInfoInCar() { System.out.println(model + ", " + color + ", " + yearOfRelease); }

    void info() { System.out.println( "Это машина."); }

    int yearDifference(int inputYear) {
        int year;
        if(inputYear > yearOfRelease) {
            year = inputYear - yearOfRelease;
        } else if (inputYear < yearOfRelease) {
            year = yearOfRelease - inputYear;
        } else {
            year = 0;
        }
        return year;
    }
}
