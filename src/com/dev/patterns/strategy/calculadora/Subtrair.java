package com.dev.patterns.strategy.calculadora;

public class Subtrair implements CalculadoraStrategy{
    @Override
    public double executarOperacao(double x, double y) {
        return x - y;
    }
}