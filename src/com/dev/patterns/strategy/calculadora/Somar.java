package com.dev.patterns.strategy.calculadora;

public class Somar implements CalculadoraStrategy{
    @Override
    public double executarOperacao(double x, double y) {
        return x + y;
    }
}
