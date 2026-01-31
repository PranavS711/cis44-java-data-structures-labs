import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Simple Calculator");
        
        while (true) {

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
       
            System.out.print("Enter operation (+, -, *, /, or q to quit): ");
            String operation = scanner.next();
            
        
            if (operation.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                break;
            }
            
            
            double num2;
            try {
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); 
                continue;
            }
            
            
            double result;
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    System.out.printf("%.2f + %.2f = %.2f%n", num1, num2, result);
                    break;
                case "-":
                    result = num1 - num2;
                    System.out.printf("%.2f - %.2f = %.2f%n", num1, num2, result);
                    break;
                case "*":
                    result = num1 * num2;
                    System.out.printf("%.2f * %.2f = %.2f%n", num1, num2, result);
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero!");
                    } else {
                        result = num1 / num2;
                        System.out.printf("%.2f / %.2f = %.2f%n", num1, num2, result);
                    }
                    break;
                default:
                    System.out.println("Invalid operation! Use +, -, *, /, or q to quit.");
            }
            
            System.out.println(); 
        }
        
        scanner.close();
    }
}

