package com.dev.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class NotacaoCientifica {

    public static void main(String[] args) {

        BigDecimal qtdDestinada = new BigDecimal("0.07");
        BigDecimal getNumeroFatorConversao = new BigDecimal("0.001");

        BigDecimal comoEstava = qtdDestinada.divide(getNumeroFatorConversao, new MathContext(16, RoundingMode.DOWN));
        BigDecimal result2 = qtdDestinada.divide(getNumeroFatorConversao, MathContext.DECIMAL64);
       // BigDecimal valorConvertido = BigDecimalUtil.toBigDecimal(comoEstava.toPlainString());

        int scale = 5;
        BigDecimal valor3 = qtdDestinada.divide(getNumeroFatorConversao, scale, RoundingMode.HALF_EVEN);

        String notacao = "7E+1";
        BigDecimal notacacoBig = new BigDecimal(notacao);
        String notacaoBigConverter = notacacoBig.toPlainString();

        System.out.println("comoEstava " + comoEstava);
        System.out.println("result2 " + result2);
       // System.out.println("valorConvertido " + valorConvertido);
        System.out.println("valor3 " + valor3);
        System.out.println("escala " + comoEstava.toPlainString());

        System.out.println("notacao " + notacacoBig);
        System.out.println("notacaoBigConverter " + notacaoBigConverter);


    }
}
