package day11.task1;

public class Task1 {
    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse();
        Picker picker1 = new Picker(warehouse1);
        Courier courier1 = new Courier(warehouse1);

        Warehouse warehouse2 = new Warehouse();
        Picker picker2 = new Picker(warehouse2);
        Courier courier2 = new Courier(warehouse2);

        System.out.println(warehouse1);
        businessProcess(picker1);
        businessProcess(courier1);
        System.out.println(warehouse1);
        System.out.println(picker1);
        System.out.println(courier1);
        businessProcess(picker1);
        System.out.println(warehouse1);
        System.out.println(picker1);
        System.out.println(courier1);
        picker1.bonus(); courier1.bonus();

        picker2.doWork();
        courier2.doWork();
        System.out.println(picker2);
        System.out.println(courier2);
        System.out.println(warehouse2);

        System.out.println(warehouse1);
        System.out.println(picker1);
        System.out.println(courier1);

    }

    static void businessProcess(Worker worker) {
        for(int i = 0; i < 10000; i++) { worker.doWork(); }
        worker.bonus();
    }
}

class Warehouse {
    private int countPickedOrders;
    private int countDeliveredOrders;

    void setCountPickedOrders(int picked) { this.countPickedOrders = picked; }
    void setCountDeliveredOrders(int delivered) { this.countDeliveredOrders = delivered; }
    int getCountPickedOrders() { return countPickedOrders; }
    int getCountDeliveredOrders() { return countDeliveredOrders; }

    public String toString() { return "Собранные посылки: " + countPickedOrders + ", Доставленные посылки: " + countDeliveredOrders; }
}

class Picker implements Worker {
    private int salary;
    private int isPayed;
    private final int pickedCap = 10000;
    private final int BONUS = 70000;
    Warehouse warehouse;

    Picker(Warehouse w) { this.warehouse = w; }

    int getSalary() { return  salary; }
    int getIsPayed() { return  isPayed; }
    int getBONUS() { return BONUS; }

    public void doWork() {
        this.salary += 80;
        warehouse.setCountPickedOrders( warehouse.getCountPickedOrders() + 1);
    }

    public void bonus() {
        if(warehouse.getCountPickedOrders() >= this.pickedCap) {
            if((warehouse.getCountPickedOrders() / this.pickedCap) > (this.isPayed / this.BONUS)) {
                this.isPayed += this.BONUS;
                System.out.println();
            } else {
                System.out.println("Сборщики за " + (warehouse.getCountPickedOrders() / this.pickedCap) + " норму бонус уже получили.");
            }
        } else {
            System.out.println("Для сборщиков бонус пока не доступен");
        }
    }

    public String toString() { return "Зарплата сборщика: " + this.salary + " , бнус сборщик: " + this.isPayed;}

}

class Courier implements Worker {
    private int salary;
    private int isPayed;
    private final int deliveredCap = 10000;
    private final int BONUS = 50000;
    Warehouse warehouse;

    Courier(Warehouse w) { this.warehouse = w; }

    int getSalary() { return salary; }
    int getIsPayed() { return isPayed; }
    int getBONUS() {return BONUS; }

    public void doWork() {
        if(warehouse.getCountPickedOrders() > warehouse.getCountDeliveredOrders()) {
            salary += 100;
            warehouse.setCountDeliveredOrders(warehouse.getCountDeliveredOrders() + 1);
        } else {
            System.out.println("Посылки ещё не собрали.");
        }
    }

    public void bonus() {
        if(warehouse.getCountDeliveredOrders() >= deliveredCap) {
            if((warehouse.getCountDeliveredOrders() / deliveredCap) > (isPayed / BONUS)) {
                isPayed += BONUS;
            } else {
                System.out.println("Курьеры за " + (warehouse.getCountDeliveredOrders() / deliveredCap) + " норму бонус уже получили.");
            }
        } else {
            System.out.println("Для сборщиков бонус пока не доступен");
        }
    }

    public String toString() { return "Зарплата курьера: " + salary + " , бнус курьера: " + isPayed;}

}