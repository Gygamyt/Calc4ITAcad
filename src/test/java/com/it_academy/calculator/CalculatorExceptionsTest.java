package com.it_academy.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorExceptionsTest {

    @ParameterizedTest
    @MethodSource("paramsForLongResultValueTest")
    public void longResultValueTest(double firstInput, double secondInput, char operation) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> CalculatorOperationsLogic.calcResult(firstInput, secondInput, operation))
                .withMessage("Too long result value.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, <"})
    public void switchDefaultCase(double firstInput, double secondInput, char invalidSymbol) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(
                        () -> CalculatorOperationsLogic.calcResult(firstInput, secondInput, invalidSymbol)
                )
                .withMessage("Something went wrong.");
    }

    @ParameterizedTest
    @CsvSource(value = {"20, 0"})
    public void divideByZeroExceptionTest(double firstInput, double zeroInput) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(
                        () -> CalculatorOperationsLogic.performDivision(firstInput, zeroInput)
                )
                .withMessage("Can't divide by zero.");
    }

    @ParameterizedTest
    @MethodSource("paramsForDoubleValueInfinityTest")
    public void isDoubleValueInfinityTest(double testValue) {
        assertThat(CalculatorOperationsLogic.isDoubleValueInfinity(testValue))
                .isEqualTo(true);
    }

    static Stream<Arguments> paramsForDoubleValueInfinityTest() {
        return Stream.of(
                Arguments.of(Double.NEGATIVE_INFINITY),
                Arguments.of(Double.POSITIVE_INFINITY)
        );
    }

    static Stream<Arguments> paramsForLongResultValueTest() {
        return Stream.of(
                Arguments.of(Double.NEGATIVE_INFINITY, 1, '-'),
                Arguments.of(Double.POSITIVE_INFINITY, 1, '+')
        );
    }
}