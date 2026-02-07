import java.util.Scanner;


interface Polygon {
    double area();
    double perimeter();
}


abstract class RegularPolygon implements Polygon {
    protected int n;
    protected double side;

    public RegularPolygon(int n, double side) {
        if (n < 3) throw new IllegalArgumentException("A polygon must have at least 3 sides.");
        if (side <= 0) throw new IllegalArgumentException("Side length must be positive.");
        this.n = n;
        this.side = side;
    }

    @Override
    public double perimeter() {
        return n * side;
    }

    @Override
    public double area() {
        return (n * side * side) / (4.0 * Math.tan(Math.PI / n));
    }
}


class Pentagon extends RegularPolygon {
    public Pentagon(double side) {
        super(5, side);
    }
}

class Hexagon extends RegularPolygon {
    public Hexagon(double side) {
        super(6, side);
    }
}

class Octagon extends RegularPolygon {
    public Octagon(double side) {
        super(8, side);
    }
}


class Triangle implements Polygon {
    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Invalid triangle sides (fails triangle inequality).");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && b + c > a;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

  
    @Override
    public double area() {
        double s = perimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}


class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}


class EquilateralTriangle extends IsoscelesTriangle {
    public EquilateralTriangle(double side) {
        super(side, side);
    }

    
    @Override
    public double area() {
        return (Math.sqrt(3) / 4.0) * a * a;
    }
}


class Quadrilateral implements Polygon {
    protected double a, b, c, d;

    public Quadrilateral(double a, double b, double c, double d) {
        if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
            throw new IllegalArgumentException("All side lengths must be positive.");
        }
        this.a = a; this.b = b; this.c = c; this.d = d;
    }

    @Override
    public double perimeter() {
        return a + b + c + d;
    }

    
    @Override
    public double area() {
        return 0;
    }
}


class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}


class Square extends Rectangle {
    public Square(double side) {
        super(side, side); 
    }
}

public class PolygonCalculator {

    private static void printMenu() {
        System.out.println("=== Polygon Calculator ===");
        System.out.println("1) Triangle");
        System.out.println("2) Isosceles Triangle");
        System.out.println("3) Equilateral Triangle");
        System.out.println("4) Quadrilateral (perimeter only)");
        System.out.println("5) Rectangle");
        System.out.println("6) Square");
        System.out.println("7) Pentagon (regular)");
        System.out.println("8) Hexagon (regular)");
        System.out.println("9) Octagon (regular)");
        System.out.println("0) Exit");
        System.out.print("Choose an option: ");
    }

    private static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double val = Double.parseDouble(line);
                if (val > 0) return val;
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void printResults(Polygon p) {
        System.out.printf("Perimeter: %.4f%n", p.perimeter());
        System.out.printf("Area:      %.4f%n%n", p.area());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                Polygon poly;

                switch (choice) {
                    case "1": { // Triangle
                        double a = readPositiveDouble(scanner, "Side a: ");
                        double b = readPositiveDouble(scanner, "Side b: ");
                        double c = readPositiveDouble(scanner, "Side c: ");
                        poly = new Triangle(a, b, c);
                        printResults(poly);
                        break;
                    }
                    case "2": { // Isosceles
                        double equalSide = readPositiveDouble(scanner, "Equal side length: ");
                        double base = readPositiveDouble(scanner, "Base length: ");
                        poly = new IsoscelesTriangle(equalSide, base);
                        printResults(poly);
                        break;
                    }
                    case "3": { // Equilateral
                        double side = readPositiveDouble(scanner, "Side length: ");
                        poly = new EquilateralTriangle(side);
                        printResults(poly);
                        break;
                    }
                    case "4": { // Quadrilateral perimeter only
                        double a = readPositiveDouble(scanner, "Side a: ");
                        double b = readPositiveDouble(scanner, "Side b: ");
                        double c = readPositiveDouble(scanner, "Side c: ");
                        double d = readPositiveDouble(scanner, "Side d: ");
                        poly = new Quadrilateral(a, b, c, d);
                        System.out.println("Note: General quadrilateral area depends on angles/diagonals; showing perimeter only.");
                        System.out.printf("Perimeter: %.4f%n%n", poly.perimeter());
                        break;
                    }
                    case "5": { // Rectangle
                        double length = readPositiveDouble(scanner, "Length: ");
                        double width = readPositiveDouble(scanner, "Width: ");
                        poly = new Rectangle(length, width);
                        printResults(poly);
                        break;
                    }
                    case "6": { // Square
                        double side = readPositiveDouble(scanner, "Side: ");
                        poly = new Square(side);
                        printResults(poly);
                        break;
                    }
                    case "7": { // Pentagon
                        double side = readPositiveDouble(scanner, "Side length: ");
                        poly = new Pentagon(side);
                        printResults(poly);
                        break;
                    }
                    case "8": { // Hexagon
                        double side = readPositiveDouble(scanner, "Side length: ");
                        poly = new Hexagon(side);
                        printResults(poly);
                        break;
                    }
                    case "9": { // Octagon
                        double side = readPositiveDouble(scanner, "Side length: ");
                        poly = new Octagon(side);
                        printResults(poly);
                        break;
                    }
                    default:
                        System.out.println("Invalid option. Try again.\n");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Try again.\n");
            }
        }

        scanner.close();
    }
}
