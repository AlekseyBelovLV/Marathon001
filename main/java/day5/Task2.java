package day5;


public class Task2 {
    public static void main(String[] args) {
        Motorbike motorbike1 = new Motorbike("Vulkan", "ораньжевый", 2020);
        motorbike1.getInfoInMotorbike();
    }
}
class Motorbike {
    private String model;
    private String color;
    private int yearOfRelease;

    public Motorbike(String model, String color, int yearOfRelease) {
        this.model = model;
        this.color = color;
        this.yearOfRelease = yearOfRelease;
    }

    void getInfoInMotorbike() {
        System.out.println(model + ", " + color + ", " + yearOfRelease);
    }
}
