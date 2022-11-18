package com.dev.patterns;

import java.util.Scanner;

public class FreteExemplo {

    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe a dist�ncia: ");
            int distancia = entrada.nextInt();
            System.out.print("Qual o tipo de frete (1) Normal, (2) Mercado Envios, (3)Sedex: ");
            int opcaoFrete = entrada.nextInt();

            TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete - 1]; //Posi��o no Enum. Ex: 2 Sedex, escolhido o n�mero 3, ent�o opcaoFrete = 3 - 1 = 2

            FreteStrategy frete = tipoFrete.obterFrete();
            double preco = frete.calcularPreco(distancia);

            System.out.printf("O valor total � de R$%.2f", preco);
        }

    }



}