import java.util.Scanner;

public class InputLogic {

    static Scanner scanner = new Scanner(System.in);

    public static double getNumber() {
        System.out.println("Input number.");
        double number;

        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Only numbers allowed.");
            scanner.next();
            number = getNumber();
        }

        return number;
    }

    public static char getOperation() {
        System.out.println("Input one of the supported operations: +, -, *, /");
        char operation;

        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Something went wrong.");
            scanner.next();
            operation = getOperation();
        }

        if (isOperationNotAllowed(operation)) {
            System.out.println("This operation is not supported or you input something else. Please, try again.");
            operation = getOperation();
        }

        return operation;
    }

    private static boolean isOperationNotAllowed(char operation) {
        return operation != '+' && operation != '-' && operation != '*' && operation != '/';
    }
}