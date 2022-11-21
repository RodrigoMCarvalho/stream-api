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
            CalculadoraStrategy valor = c.obterOperacao();
            System.out.println(valor.executarOperacao(x,y));
        });

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe o primeiro numero: ");
            int n1 = entrada.nextInt();
            System.out.print("Informe o segundo numero: ");
            int n2 = entrada.nextInt();
            System.out.print("Qual o a operação (1) SOMAR, (2) SUBSTRAIR, (3) MULTIPLICAR, (4) DIVIDIR: ");
            int opcaoOperacao = entrada.nextInt();

            CalculadoraEnum calculadoraEnum = CalculadoraEnum.obterCalculadoraEnum(opcaoOperacao);
            CalculadoraStrategy strategy = calculadoraEnum.obterOperacao();
            double valor = strategy.executarOperacao(n1, n2);

            System.out.println("O resultado da operação " + n1 + " " + calculadoraEnum.toString() + " " + n2+  " é : " + valor);
        }


    }
}
