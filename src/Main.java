public class Main {
    public static void main(String[] args) {

        double firstNumber = InputLogic.getNumber();

        char operation = InputLogic.getOperation();

        double secondNumber = InputLogic.getNumber();

        try {
            System.out.println(OperationsLogic.calcResult(firstNumber, secondNumber, operation));
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}