package com.it_academy.calculator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
public class CalculatorInputLogicTest {    //ne yspel dodelat' :(

    private final static InputStream systemIn = System.in;
    private final static PrintStream systemOut = System.out;
    private ByteArrayInputStream typeIn;
    private static ByteArrayOutputStream typeOut;


    @ParameterizedTest
    @MethodSource("paramsForInputCharTest")
    public void inputCorrectCharTest(String input, char result) throws IOException {
        typeIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(typeIn);
        assertThat(CalculatorInputLogic.getOperation()).isEqualTo(result);
        System.setIn(systemIn);
    }


    static Stream<Arguments> paramsForInputCharTest() {
        return Stream.of(Arguments.of("+", '+'),
                Arguments.of("-", '-'),
                Arguments.of("/", '/'),
                Arguments.of("*", '*'));
    }

    @ParameterizedTest
    @MethodSource("paramsForInputNumberTest")
    public void inputCorrectNumberTest(String input, double result) {
        typeIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(typeIn);
        assertThat(CalculatorInputLogic.getNumber()).isEqualTo(result);
    }

    static Stream<Arguments> paramsForInputNumberTest() {
        return Stream.of(Arguments.of("12", 12));
    }

//    @BeforeEach
//    void setUp() throws IOException {
//        typeOut = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(typeOut));
//    }
//
//    @AfterEach
//    void tearDown() throws IOException {
//        typeIn.close();
//        System.setIn(systemIn);
//        System.setOut(systemOut);
//    }
}