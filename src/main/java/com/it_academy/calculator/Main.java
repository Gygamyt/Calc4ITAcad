package com.it_academy.calculator;

public class Main {
    public static void main(String[] args) {

        double firstNumber = CalculatorInputLogic.getNumber();

        char operation = CalculatorInputLogic.getOperation();

        double secondNumber = CalculatorInputLogic.getNumber();

        try {
            System.out.println(CalculatorOperationsLogic.calcResult(firstNumber, secondNumber, operation));
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}