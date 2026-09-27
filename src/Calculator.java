import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("========================================");
        System.out.println("        JAVA CLI CALCULATOR v2.0");
        System.out.println("========================================");

        while (running) {

            printMenu();

            System.out.print("Enter your choice (1-5): ");

            // Validate menu input
            if (!scanner.hasNextInt()) {
                System.out.println(
                        "Invalid input! Please enter a number from 1 to 5."
                );
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            // Exit
            if (choice == 5) {
                running = false;

                System.out.println();
                System.out.println("========================================");
                System.out.println("Thank you for using the calculator!");
                System.out.println("========================================");

                break;
            }

            // Validate menu option
            if (choice < 1 || choice > 5) {
                System.out.println(
                        "Invalid choice! Please select an option from 1 to 5."
                );
                continue;
            }

            // Get first number
            double firstNumber = readNumber(
                    scanner,
                    "Enter first number: "
            );

            // Get second number
            double secondNumber = readNumber(
                    scanner,
                    "Enter second number: "
            );

            // Perform calculation
            switch (choice) {

                case 1:
                    // Addition
                    double addition = firstNumber + secondNumber;

                    System.out.println(
                            "Result: " + formatResult(addition)
                    );
                    break;

                case 2:
                    // Subtraction
                    double subtraction = firstNumber - secondNumber;

                    System.out.println(
                            "Result: " + formatResult(subtraction)
                    );
                    break;

                case 3:
                    // Multiplication
                    double multiplication = firstNumber * secondNumber;

                    System.out.println(
                            "Result: " + formatResult(multiplication)
                    );
                    break;

                case 4:
                    // Division
                    if (secondNumber == 0) {

                        System.out.println(
                                "Error: Cannot divide by zero!"
                        );

                    } else {

                        double division =
                                firstNumber / secondNumber;

                        System.out.println(
                                "Result: " + formatResult(division)
                        );
                    }

                    break;

                default:
                    System.out.println("Unexpected error.");
            }
        }

        scanner.close();
    }

    /**
     * Displays the calculator menu.
     */
    private static void printMenu() {

        System.out.println();
        System.out.println("Select an operation:");
        System.out.println("1. Addition       (+)");
        System.out.println("2. Subtraction    (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division       (/)");
        System.out.println("5. Exit");
        System.out.println();
    }

    /**
     * Reads and validates a numeric value from the user.
     */
    private static double readNumber(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextDouble()) {

                return scanner.nextDouble();

            } else {

                System.out.println(
                        "Invalid number! Please enter a valid numeric value."
                );

                scanner.next();
            }
        }
    }

    /**
     * Removes unnecessary decimal .0 from whole numbers.
     *
     * Example:
     * 10.0 -> 10
     * 5.5  -> 5.5
     */
    private static String formatResult(double result) {

        if (Double.isFinite(result)
                && result == Math.rint(result)) {

            return String.valueOf((long) result);
        }

        return String.valueOf(result);
    }
}