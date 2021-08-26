package day3;

import java.util.Scanner;

public class Task1 {
        private static final Scanner SCN = new Scanner(System.in);
        private static String city = " ";
        private static String stop = "Работаем";

    public static void main(String[] args) {
        while (!stringEquals(city, stop)) {

            city = SCN.nextLine();

            switch (city) {
                case "Стоп":
                    stop = city;
                    break;
                case "Москва":
                case "Владивосток":
                case "Ростов":
                    System.out.println("Россия");
                    break;
                case "Рим":
                case "Милан":
                case "Турин":
                    System.out.println("Италия");
                    break;
                case "Ливерпуль":
                case "Манчестер":
                case "Лондон":
                    System.out.println("Англия");
                    break;
                case "Берлин":
                case "Мюнхен":
                case "Кёльн":
                    System.out.println("Германия");
                    break;
                default:
                    System.out.println("Неизвестная страна");
            }
        }
        SCN.close();
        System.out.println("Программа остановленна");
        System.out.println(stop);
    }

    private static boolean stringEquals(String a, String b) {
        return a.equals(b);
    }
}
