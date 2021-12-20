package com.dev.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraJurosCompostos {

    public static void main(String[] args) {
        //https://mundoeducacao.uol.com.br/matematica/juros-compostos.htm
        BigDecimal capital = toBigDecimal("3000");
        BigDecimal taxaJuros = toBigDecimal("3");
        BigDecimal periodo = toBigDecimal("1");

        /**
         * Capital = 3000
         * Juros de 3% + 3000 = 90
         * Montante (R$) 3000 + 90 = 3090
         * Montante (R$) 3000 . (1 + 0,03)¹
         */

        BigDecimal montante = taxaJuros.divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
        montante = montante.add(BigDecimal.ONE);
        montante = montante.pow(periodo.intValue());
        montante = montante.multiply(capital);
        montante = montante.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println(String.format("O valor do montante eh: %s", montante));

    }

    public static BigDecimal toBigDecimal(String valor) {
        try{
            return new BigDecimal(valor).setScale(4, RoundingMode.HALF_EVEN); //Padrao definido pelo Banco Central para calculos finaceiros
        } catch (Exception ex) {
            return BigDecimal.ZERO;
        }
    }
}
