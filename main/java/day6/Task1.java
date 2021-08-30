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

