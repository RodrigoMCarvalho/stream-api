package com.dev.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigdecimalTest {

    public static void main(String[] args) {

        BigDecimal valor1 = BigDecimal.valueOf(10);
        BigDecimal valor2 = BigDecimal.valueOf(20);
        BigDecimal valor1Igual = BigDecimal.valueOf(10);
        BigDecimal resultado;

        resultado = valor1.add(valor2);
        System.out.println(resultado.toPlainString());

        resultado = valor1.subtract(valor2);
        System.out.println(resultado.toPlainString());

        resultado = valor1.multiply(valor2);
        System.out.println(resultado.toPlainString());

        resultado = valor1.divide(valor2, RoundingMode.HALF_EVEN);
        System.out.println(resultado.toPlainString());

        //FIXME : Forma de comparar valores
        if (valor1.compareTo(valor2) < 0) {
            System.out.println("Valor 2 eh MAIOR q Valor 1");
        }

        if (valor2.compareTo(valor1) > 0) {
            System.out.println("Valor 1 eh MENOR q Valor 2");
        }

        if (valor1.compareTo(valor1Igual) == 0) {
            System.out.println("Os valores sao IGUAIS");
        }

        if (valor1.compareTo(valor2) != 0) {
            System.out.println("Os valores sao DIFERENTES");
        }
    }











}
