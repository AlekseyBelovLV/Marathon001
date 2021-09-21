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

        picker2.doWork();
        courier2.doWork();
        System.out.println(warehouse2);
        System.out.println(picker2);
        System.out.println(courier2);
        System.out.println(warehouse1);
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
    private int paidBonus;
    private boolean isPayed;
    private final int BONUS = 70000;
    private Warehouse warehouse;

    Picker(Warehouse w) { this.warehouse = w; }

    int getSalary() { return  salary; } // ?
    boolean getIsPayed() { return isPayed; } // ?

    public void doWork() {
        this.salary += 80;
        warehouse.setCountPickedOrders( warehouse.getCountPickedOrders() + 1);
        if(warehouse.getCountPickedOrders() % 10000 == 0) { this.isPayed = true; }
    }

    public void bonus() {
        if(this.isPayed) {
            this.paidBonus += BONUS;
            this.isPayed = false;
        } else {
            System.out.println("Для сборщиков бонус пока не доступен.");
        }
    }

    public String toString() { return "Зарплата сборщика: " + this.salary + " , бнус сборщик: " + this.paidBonus;}
}

class Courier implements Worker {
    private int salary;
    private int paidBonus;
    private boolean isPayed;
    private final int BONUS = 50000;
    private Warehouse warehouse;

    Courier(Warehouse w) { this.warehouse = w; }

    int getSalary() { return salary; } // ?
    boolean getIsPayed() { return isPayed; } // ?

    public void doWork() {
        if(warehouse.getCountPickedOrders() > warehouse.getCountDeliveredOrders()) {
            salary += 100;
            warehouse.setCountDeliveredOrders(warehouse.getCountDeliveredOrders() + 1);
            if(warehouse.getCountDeliveredOrders() % 10000 == 0) { this.isPayed = true; }
        } else {
            System.out.println("Посылки ещё не собрали.");
        }
    }

    public void bonus() {
        if(this.isPayed) {
            this.paidBonus += this.BONUS;
            this.isPayed = false;
        } else {
            System.out.println("Для курьеров бонус пока не доступен.");
        }
    }

    public String toString() { return "Зарплата курьера: " + salary + " , бнус курьера: " + paidBonus;}
}