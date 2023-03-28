package com.it_academy.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorBasicOperationsLogicTest {

    @ParameterizedTest
    @MethodSource("paramsForAdditionTest")
    public void additionTest(double expected, double firstInput, double secondInput) {
        assertThat(CalculatorOperationsLogic.performAddition(firstInput, secondInput))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForSubtractionTest")
    public void subtractionTest(double expected, double firstInput, double secondInput) {
        assertThat(CalculatorOperationsLogic.performSubtraction(firstInput, secondInput))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiplicationTest")
    public void multiplicationTest(double expected, double firstInput, double secondInput) {
        assertThat(CalculatorOperationsLogic.performMultiplication(firstInput, secondInput))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivisionTest")
    public void divisionTest(double expected, double firstInput, double secondInput) {
        assertThat(CalculatorOperationsLogic.performDivision(firstInput, secondInput))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForCalcResultTest")
    public void calcResultTest(double expected, double firstInput, double secondInput, char operation) {
        assertThat(CalculatorOperationsLogic.calcResult(firstInput, secondInput, operation))
                .isEqualTo(expected);
    }

    static Stream<Arguments> paramsForCalcResultTest() {
        return Stream.of(
                Arguments.of(2323, -2323, -1, '*'),
                Arguments.of(312, 132, 180, '+'),
                Arguments.of(4, 656, 164, '/'),
                Arguments.of(200, 3465, 3265, '-')
        );
    }

    static Stream<Arguments> paramsForAdditionTest() {
        return Stream.of(
                Arguments.arguments(20, 14, 6),
                Arguments.arguments(324, 300, 24),
                Arguments.arguments(-120, 0, -120),
                Arguments.arguments(2000, 2129, -129)
        );
    }

    static Stream<Arguments> paramsForSubtractionTest() {
        return Stream.of(
                Arguments.arguments(8, 14, 6),
                Arguments.arguments(-5434, -2456, 2978),
                Arguments.arguments(-120, -240, -120),
                Arguments.arguments(2258, 2129, -129)
        );
    }

    static Stream<Arguments> paramsForMultiplicationTest() {
        return Stream.of(
                Arguments.arguments(374, 34, 11),
                Arguments.arguments(-7368, -2456, 3),
                Arguments.arguments(288, -24, -12),
                Arguments.arguments(-2129, 2129, -1)
        );
    }

    static Stream<Arguments> paramsForDivisionTest() {
        return Stream.of(
                Arguments.arguments(12.5, 25, 2),
                Arguments.arguments(26, 156, 6),
                Arguments.arguments(-246, -492, 2),
                Arguments.arguments(-2129, 2129, -1)
        );
    }
}
