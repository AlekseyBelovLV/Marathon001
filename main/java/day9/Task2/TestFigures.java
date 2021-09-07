package day9.Task2;

public class TestFigures {
    public static void main(String[] args) {
        Figure[] figures = {
                new Triangle("Red", 10, 10, 10),
                new Triangle("Green", 10, 20, 30),
                new Triangle("Red", 10, 20, 15),
                new Rectangle("Red", 5, 10),
                new Rectangle("Orange", 40, 15),
                new Circle("Red", 4),
                new Circle("Red", 10),
                new Circle("Blue", 5)
        };

        System.out.println(calculateRedPerimeter(figures));
        System.out.println(calculateRedArea(figures));
    }

    public static double calculateRedPerimeter(Figure[] figures) {
        String emptyColor = "Red";
        double sumPerimeter = 0;
        for(Figure i: figures) {
            if(i.getColor().equals(emptyColor)) {
                sumPerimeter += i.perimeter();
            }
        }
        return sumPerimeter;
    }

    public static double calculateRedArea(Figure[] f) {
        String emptyColor = "Red";
        double sumArea = 0;
        for(Figure i: f) {
            if(i.getColor().equals(emptyColor)) {
                sumArea += i.area();
            }
        }
        return sumArea;

    }

}
abstract class Figure {
    private final String color;

    Figure(String color) { this.color = color; }

    String getColor() { return color; }

    public abstract double area();
    public abstract double perimeter();
}

class Circle extends Figure {
    private final int radius;

    Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    public double area() { return Math.PI * (radius * radius); }

    public double perimeter() { return 2 * (Math.PI * radius);}
}

class Rectangle extends Figure {
    private final int height;
    private final int width;

    Rectangle(String color, int height, int width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    public double area() { return height * width;}

    public double perimeter() { return 2 * (height + width);}
}

class Triangle extends Figure {
    private final int a;
    private final int b;
    private final int c;

    Triangle(String color, int a, int b, int c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() { return Math.sqrt(perimeter() * (perimeter() - a) * (perimeter() - b) * (perimeter() - c)); }

    public double perimeter() { return a + b + c;}
}