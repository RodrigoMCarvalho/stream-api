package com.dev.patterns.strategy.frete;

public class Sedex implements FreteStrategy {

    public double calcularPreco(int distancia) {
        System.out.println("Modo escolhido SEDEX");
        return distancia * 5.99 + 4;
    }
}
