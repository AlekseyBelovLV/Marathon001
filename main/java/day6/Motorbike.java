package day6;


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

    int yearDifference(int inputYear) { return inputYear - yearOfRelease; }
}
