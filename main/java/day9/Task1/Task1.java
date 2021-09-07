package day9.Task1;

public class Task1 {
    public static void main(String[] args) {
        Student student1 = new Student("Андрей", "1-й курс");
        Teacher teacher1 = new Teacher("Анна Петровна", "Химия");
        System.out.println(student1.getGroupName());
        System.out.println(teacher1.getSubjectName());
        student1.printInfo();
        teacher1.printInfo();
    }
}

class Human {
    private String name;

    Human(String name) { this.name = name; }

    public String getName() { return name; }

    public void printInfo() { System.out.println("Этот человек с именем " + name); }
}

class Teacher extends Human {
    private String subjectName;

    Teacher(String name, String subjectName) {
        super(name);
        this.subjectName = subjectName;
    }

    String getSubjectName() { return subjectName; }

    public void printInfo() {
        super.printInfo();
        System.out.println("Этот преподаватель с именем " + getName());
    }

}

class Student extends Human{
    private String groupName;

    Student(String name, String groupName) {
        super(name);
        this.groupName = groupName;
    }

    public String getGroupName() { return groupName; }

    public void printInfo() {
        super.printInfo();
        System.out.println("Это студент с именем " + getName());
    }
}