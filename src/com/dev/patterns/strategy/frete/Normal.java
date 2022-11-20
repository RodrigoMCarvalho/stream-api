package com.dev.patterns.strategy.frete;

public class Normal implements FreteStrategy {

    public double calcularPreco(int distancia) {
        System.out.println("Modo escolhido Normal");
        return distancia * 1.45 + 12;
    }
}
