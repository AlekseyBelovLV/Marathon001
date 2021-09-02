package day6;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Лариса Петровна", "химия");
        Student student1 = new Student("Валерий Кузнецов");
        teacher1.evaluate(student1.getName());
    }
}
class Teacher {
    private String name;
    private String lesson;
    private Random rnd = new Random();// Вопрос, где в данном случае лучше создавать об. Random ?

    Teacher(String name, String lesson) {
        this.name = name;
        this.lesson = lesson;
    }

    public void evaluate(String nameStudent) {
        String[] ratings = {"отлично", "хорошо", "удовлетворительно", "неудовлетварительно"};
        String rating;
        rating = ratings[rnd.nextInt(4)];

        System.out.println("Преподаватель " + name +
                " оценил студента с именем " + nameStudent +
                ", по предмету " + lesson +
                " на оценку " + rating + ".");
    }
}

class Student {
    String name;

    Student(String name) { this.name = name; }

    String getName() { return name; }
}