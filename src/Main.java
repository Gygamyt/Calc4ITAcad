public class Main {
    public static void main(String[] args) {

        int firstNumber = InputLogic.getNumber();

        char operation = InputLogic.getOperation();

        int secondNumber = InputLogic.getNumber();

        System.out.println(OperationsLogic.calcResult(firstNumber, secondNumber, operation));
    }
}