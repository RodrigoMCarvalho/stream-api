package com.dev.bigdecimal;

import java.math.BigDecimal;

public class Porcentagem {

    public static void main(String[] args) {
        BigDecimal desconto = BigDecimal.valueOf(20);
        BigDecimal valor = BigDecimal.valueOf(9000);
        System.out.println(calcularDescontoAplicado(desconto, valor));
        System.out.println(calcularValorComDesconto(desconto, valor));
    }

    public static BigDecimal calcularDescontoAplicado(BigDecimal desconto, BigDecimal valor) {
        return desconto.multiply(valor).divide(BigDecimal.valueOf(100));
    }

    public static BigDecimal calcularValorComDesconto(BigDecimal desconto, BigDecimal valor) {
        return valor.subtract(calcularDescontoAplicado(desconto, valor));
    }


}
