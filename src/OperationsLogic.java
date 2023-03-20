public class OperationsLogic {
    public static double performAddition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double performSubtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double performMultiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double performDivision(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

    public static boolean isDoubleValueInfinity(double result) {
        return result == Double.NEGATIVE_INFINITY || result == Double.POSITIVE_INFINITY;
    }

    public static double calcResult(double firstNumber, double secondNumber, char operation) {
        double result;

        switch (operation) {
            case '+' -> result = performAddition(firstNumber, secondNumber);
            case '-' -> result = performSubtraction(firstNumber, secondNumber);
            case '/' -> {
                if (secondNumber == 0) {
                    throw new ArithmeticException("Can't divide by zero.");
                } else result = performDivision(firstNumber, secondNumber);
            }
            case '*' -> result = performMultiplication(firstNumber, secondNumber);
            default -> throw new IllegalArgumentException("Something went wrong.");
        }
        if (isDoubleValueInfinity(result)) {
            throw new ArithmeticException("Too long result value.");
        } else return result;
    }
}