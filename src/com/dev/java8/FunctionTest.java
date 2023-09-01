package com.dev.java8;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

        System.out.println(getToPlainStringFunction().apply(new BigDecimal("7E+1")));

        System.out.println(getIntegerDoubleFunction().apply(5));
        System.out.println(getIntegerDoubleFunction2.apply(6));

        Function<String, Integer> multiplyWord = FunctionTest::multiplyWord;
        System.out.println(multiplyWord.apply("Rodrigo"));
        System.out.println(multiplyWordFunction().apply("Rodrigo"));

        System.out.println(incrementByOneFunction.apply(1));
    }

    private static Function<BigDecimal, String> getToPlainStringFunction() {
        return BigDecimal::toPlainString;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number++;

    private static Function<Integer, Double> getIntegerDoubleFunction() {
        return Integer::doubleValue;
    }
    static Function<Integer, Double> getIntegerDoubleFunction2 = Integer::doubleValue;

    public static int multiplyWord(String palavra) {
        return palavra.length() * 10;
    }

    static Function<String, Integer> multiplyWordFunction() {
        return palavra -> palavra.length() * 10;
    }

    public static Function<String, Integer> multiplyWord2TestenadoNull() {
        return palavra -> {
            if(Objects.isNull(palavra)) {
                return null;
            }
            return  palavra.length() * 10;
        };
    }


}
