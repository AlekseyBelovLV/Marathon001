package day11.task1;

public class Task1 {

    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse();
        Picker picker1 = new Picker(warehouse1);
        Courier courier1 = new Courier(warehouse1);

        Warehouse warehouse2 = new Warehouse();
        Picker picker2 = new Picker(warehouse2);
        Courier courier2 = new Courier(warehouse2);

        businessProcess(picker1);
        businessProcess(courier1);
        warehouse1.infoWarehouse();
        picker1.infoPicker(); courier1.infoCourier();

        picker2.doWork(); courier2.doWork();
        warehouse2.infoWarehouse();
        picker2.infoPicker(); courier2.infoCourier();

        warehouse1.infoWarehouse();
        picker1.infoPicker(); courier1.infoCourier();

    }

    static void businessProcess(Worker worker) {
        for(int i = 0; i < 10000; i++) {
            worker.doWork();
        }
        worker.bonus();
    }

    private static void brigadePickersWork(Picker[] pickers) {
        for(Picker i: pickers) { i.doWork();}
    }
    private static void infoBrigadePickers(Picker[] pickers) {
        for(Picker i: pickers) { i.infoPicker();}
    }
    private static void bonusBrigadePickers(Picker[] pickers) {
        for(Picker i: pickers) { i.bonus();}
    }

}

class Warehouse {
    private int countPickedOrders;
    private int countDeliveredOrders;

    void setCountPickedOrders(int picked) { this.countPickedOrders = picked; }
    void setCountDeliveredOrders(int delivered) { this.countDeliveredOrders = delivered; }
    int getCountPickedOrders() { return countPickedOrders; }
    int getCountDeliveredOrders() { return countDeliveredOrders; }

    public void infoWarehouse() {
        String picked = Integer.toString(countPickedOrders);
        String delivered = Integer.toString(countDeliveredOrders);
        System.out.println("Собранные посылки: " + picked + ". Доставленные посылки: " + delivered);
    }
}

class Picker implements Worker {
    private int salary;
    private int isPayed;
    private final int pickedCap = 70000;
    private final int BONUS = 10000;
    Warehouse warehouse;

    Picker(Warehouse w) { this.warehouse = w; }

    int getSalary() { return salary; }
    int getIsPayed() { return isPayed; }
    int getBonus() { return BONUS; }

    public void doWork() {
        salary += 80;
        warehouse.setCountPickedOrders( warehouse.getCountPickedOrders() + 1);
    }

    public void bonus() {
        if(warehouse.getCountPickedOrders() >= BONUS) {
            if((warehouse.getCountPickedOrders() / BONUS) != (isPayed / pickedCap)) {
                isPayed += pickedCap;
            } else {
                System.out.println("За " + (warehouse.getCountPickedOrders() / BONUS) + " норму бонус уже был выплачен.");
            }

        } else {
            System.out.println("Для сборщиков бонус пока не доступен.");
        }
    }

    public void infoPicker() {
        String salaryPicker = Integer.toString(salary);
        String isPayedPicker = Integer.toString(isPayed);
        System.out.println("Зарплата сборщика: " + salaryPicker + ". Бонус сборщика: " + isPayedPicker);
    }
}

class Courier implements Worker {
    private int salary;
    private int isPayed;
    private final int pickedCap = 50000;
    private final int BONUS = 10000;

    Warehouse warehouse;

    Courier(Warehouse w) { this.warehouse = w; }

    int getSalary() { return salary; }
    int getIsPayed() { return isPayed; }
    int getBonus() { return BONUS; }

    public void doWork() {
        if(warehouse.getCountPickedOrders() > warehouse.getCountDeliveredOrders()) {
            salary += 100;
            warehouse.setCountDeliveredOrders(warehouse.getCountDeliveredOrders() + 1);
        } else {
            System.out.println("Посылки ещё не собрали.");
        }
    }

    public void bonus() {
        if(warehouse.getCountDeliveredOrders() >= BONUS) {
            if((warehouse.getCountDeliveredOrders() / BONUS) != (isPayed / pickedCap)) {
                isPayed += pickedCap;
            } else {
                System.out.println("За " + (warehouse.getCountDeliveredOrders() / BONUS) + " норму бонус уже был выплачен.");
            }

        } else {
            System.out.println("Для курьеров бонус пока не доступен.");
        }
    }

    public void infoCourier() {
        String salaryCourier = Integer.toString(salary);
        String isPayedCourier = Integer.toString(isPayed);
        System.out.println("Зарплата курьера: " + salaryCourier + ". Бонус курьера: " + isPayedCourier);
    }

}