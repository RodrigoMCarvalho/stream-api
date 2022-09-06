package com.dev.bigdecimal;

import com.dev.models.Produto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class BigdecimalTest {

    public static void main(String[] args) {

        BigDecimal valor1 = BigDecimal.valueOf(10);
        BigDecimal valor2 = BigDecimal.valueOf(20);
        BigDecimal valor1Igual = BigDecimal.valueOf(10);
        BigDecimal resultado;

        resultado = valor1.add(valor2);
        System.out.println(resultado.toPlainString());

        resultado = valor2.subtract(valor1);
        System.out.println(resultado.toPlainString());

        resultado = valor1.multiply(valor2);
        System.out.println(resultado.toPlainString());

        resultado = valor2.divide(valor1, RoundingMode.HALF_EVEN);
        System.out.println(resultado.toPlainString());

        resultado = valor2.divide(valor1, RoundingMode.HALF_EVEN);
        System.out.println(resultado.toPlainString());

        System.out.println(valor2.pow(3));

        System.out.println(valor1.min(valor2));

        System.out.println(valor1.max(valor2));

        //FIXME : Forma de comparar valores
        if (valor1.compareTo(valor2) < 0) {
            System.out.println("Valor 1 eh MENOR q Valor 2");
        }

        if (valor1.compareTo(valor2) > 0) {
            System.out.println("Valor 1 eh MAIOR q Valor 2");
        }

        if (valor1.compareTo(valor1Igual) == 0) {
            System.out.println("Os valores sao IGUAIS");
        }

        if (valor1.compareTo(valor2) != 0) {
            System.out.println("Os valores sao DIFERENTES");
        }

        List<Produto> produtos = List.of(
                new Produto("prod1", new BigDecimal(100)),
                new Produto("prod2", new BigDecimal(200)),
                new Produto("prod3", new BigDecimal(300)));

        //Calculando média com BigDecimal
        BigDecimal media = calcularMedia(produtos.stream().map(Produto::getPreco).collect(Collectors.toList()));
        System.out.println(media);

        //Calculando as estatísticas usando a classe utilitária BigDecimalSummaryStatistics
        BigDecimalSummaryStatistics collect = produtos.stream().map(Produto::getPreco).collect(BigDecimalSummaryStatistics.statistics());
        System.out.println("Media: " + collect.getAverage(MathContext.DECIMAL128));
        System.out.println("Maximo: " + collect.getMax());
        System.out.println("Minimo: " + collect.getMin());
        System.out.println("Contador: " + collect.getCount());
        System.out.println("Soma: " + collect.getSum());

        System.out.println(new BigDecimal("1000"));  //1000
        System.out.println(new BigDecimal("1000").setScale(3, RoundingMode.HALF_EVEN));  //1000.000
        System.out.println(new BigDecimal("1.000"));  //1.000
        System.out.println(new BigDecimal("1").setScale(3, RoundingMode.HALF_EVEN));  //1.000
        System.out.println(new BigDecimal("1.000").setScale(4, RoundingMode.HALF_EVEN));  //1.0000

    }

    public static BigDecimal calcularMedia(List<BigDecimal> values) {

        BigDecimal media;
        int positionNumber = (int) ((values.size() +1) /2.0)- 1;
        if (values.size() % 2 == 0) {
            media = (values.get(positionNumber).add(values.get(positionNumber + 1))).divide(new BigDecimal(2), 6, RoundingMode.HALF_UP);
        } else {
            media = values.get(positionNumber);
        }
        return media;

    }










}
