package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    private static Scanner scn;
    public static void main(String[] args) {
        File file = new File("people.txt");
        try {
            System.out.println(parseToObjList(file));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (ScannerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Person> parseToObjList(File file) throws FileNotFoundException, ScannerException {
        List<Person> nameList = new ArrayList<>();
        if(fileIsCorrect(file)) {
            scn = new Scanner(file);
            while(scn.hasNextLine()){
                String[] nameAndAge = scn.nextLine().split(" ");
                nameList.add(new Person(nameAndAge[0], Integer.parseInt(nameAndAge[1])));
            }
        }
        scn.close();
        return nameList;
    }

    private static boolean fileIsCorrect(File file) throws FileNotFoundException, ScannerException {
        scn = new Scanner(file);
        while(scn.hasNextLine()) {
            String[] tempStrings = scn.nextLine().split(" ");
            if(Integer.parseInt(tempStrings[1]) < 0) {
                scn.close();
                throw new ScannerException("Некорректный входной файл."); }
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
