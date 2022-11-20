package com.dev.patterns.strategy.calculadora;

import java.util.Arrays;

public enum CalculadoraEnum {

    SOMAR ("+", 1) {
        @Override
        public double executarOperacao(double x, double y) {
            return x + y;
        }
    },
    SUBTRAIR("-", 2) {
        @Override
        public double executarOperacao(double x, double y) {
            return x - y;
        }
    },
    MULTIPLICAR("*", 3) {
        @Override
        public double executarOperacao ( double x, double y){
            return x * y;
        }
    },
    DIVIDIR("/", 4) {
        @Override
        public double executarOperacao(double x, double y) {
            return x / y;
        }
    };

    CalculadoraEnum(String simbolo, int codigo) {
        this.simbolo = simbolo;
        this.codigo = codigo;
    }

    private final String simbolo;
    private final int codigo;

    public abstract double executarOperacao(double x, double y);

    public static CalculadoraEnum obterOperacao(int codigo) {
        return Arrays.stream(CalculadoraEnum.values())
                .filter(s -> s.getCodigo() == codigo)
                .findFirst().orElse(null);
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return this.simbolo;
    }
}
