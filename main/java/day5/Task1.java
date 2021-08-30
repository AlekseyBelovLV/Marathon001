package day5;

public class Task1 {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setModel("WV Гольф");
        car1.setColor("зелёный");
        car1.setYearOfRelease(2021);

        car1.getInfoForCar();
    }
}
class Car {
    private String model;
    private String color;
    int yearOfRelease;

    public void setModel(String carModel) { model = carModel; }
    public String getModel() { return model; }

    public void setColor(String carColor) { color = carColor; }
    public String getColor() { return color; }

    public void setYearOfRelease(int carYearOfRelease) { yearOfRelease = carYearOfRelease;}
    public int getYearOfRelease() { return yearOfRelease; }

    void getInfoForCar() {
        System.out.println("Модель машины: " + getModel());
        System.out.println("Цвет машины: " + getColor());
        System.out.println("Год выпаска: " + getYearOfRelease() + " год.");
    }
}
