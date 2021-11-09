package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    private static Scanner scn;
    public static void main(String[] args) {
        File file = new File("people");
        try {
            System.out.println(parseToObjList(file));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }

    public static List<Person> parseToObjList(File file) throws FileNotFoundException {
        List<Person> nameList = new ArrayList<>();
        if(fileIsCorrect(file)) {
            scn = new Scanner(file);
            while(scn.hasNextLine()){
                String line = scn.nextLine();
                String[] nameAndAge = line.split(" ");
                String s = nameAndAge[0];
                int i = Integer.parseInt(nameAndAge[1]);
                nameList.add(new Person(s, i));
            }
        }
        scn.close();
        return nameList;
    }

    private static boolean fileIsCorrect(File file) throws FileNotFoundException {
        scn = new Scanner(file);
        while(scn.hasNextLine()) {
            String line = scn.nextLine();
            String[] tempStrings = line.split(" ");
            if(Integer.parseInt(tempStrings[1]) < 0) {
                try{
                    throw new ScannerException();
                } catch (ScannerException e) {
                    System.out.println("Некорректный входной файл.");
                }
                return false;
            }
        }
        return true;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() { return "{name='" + name + "' year=" + age + "}"; }
}
