package com.dev.patterns.strategy.calculadora;

import java.util.Arrays;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        double x = 3.0;
        double y = 2.0;

        Arrays.stream(CalculadoraEnum.values()).forEach( c ->  {
            System.out.print(x + " ");
            System.out.print(c.toString() + " ");
            System.out.print(y + " = ");
            System.out.println(c.executarOperacao(x, y));
        });

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe o primeiro numero: ");
            int n1 = entrada.nextInt();
            System.out.print("Informe o segundo numero: ");
            int n2 = entrada.nextInt();
            System.out.print("Qual o a operação (1) SOMAR, (2) SUBSTRAIR, (3)MULTIPLICAR, (4)DIVIDIR ");
            int opcaoOperacao = entrada.nextInt();

            CalculadoraEnum operacao = CalculadoraEnum.obterOperacao(opcaoOperacao);
            double valor = operacao.executarOperacao(n1, n2);

            System.out.println("O valor da operação " + n1 + " " + operacao.toString() + " " + n2+  " é : " + valor);
        }


    }
}
