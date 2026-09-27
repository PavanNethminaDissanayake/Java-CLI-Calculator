import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("       JAVA CLI CALCULATOR");

        boolean running = true;

        while (running) {

            System.out.println("1. Addition (+)");
            System.out.println("2. Minus (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (%)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            // Validate menu input
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next();
                continue;
            }

            if (choice == 5) {
                running = false;
                break;
            }

            if (choice < 1 || choice > 5) {
                continue;
            }

            System.out.print("Enter first number: ");

            if (!scanner.hasNextDouble()) {
                scanner.next();
                continue;
            }

            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");

            if (!scanner.hasNextDouble()) {
                scanner.next();
                continue;
            }

            double num2 = scanner.nextDouble();

            double result;

            switch (choice) {

                case 1:
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;

                case 2:
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;

                case 3:
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;

                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero!");
                    } else {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    }
                    break;
            }
        }

        scanner.close();
    }
}