package day6;

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

    int yearDifference(int inputYear) { return inputYear - yearOfRelease; }

}
