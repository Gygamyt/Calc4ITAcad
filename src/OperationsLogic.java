public class OperationsLogic {
    public static int addition(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int subtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static int division(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    public static int calcResult(int firstNumber, int secondNumber, char operation) {
        int result;
        switch (operation) {
            case '+' -> result = addition(firstNumber, secondNumber);
            case '-' -> result = subtraction(firstNumber, secondNumber);
            case '/' -> result = division(firstNumber, secondNumber);
            case '*' -> result = multiplication(firstNumber, secondNumber);
            default -> {
                result = 0;
                System.out.println("Something went wrong.");
            }
        }
        return result;
    }
}