package com.dev.patterns.strategy.calculadora;

import java.util.Arrays;

public enum CalculadoraEnum {

    SOMAR ("+", 1) {
        @Override
        public CalculadoraStrategy obterOperacao() {
            return new Somar();
        }
    },
    SUBTRAIR("-", 2) {
        @Override
        public CalculadoraStrategy obterOperacao() {
            return new Subtrair();
        }
    },
    MULTIPLICAR("*", 3) {
        @Override
        public CalculadoraStrategy obterOperacao(){
            return new Multiplicar();
        }
    },
    DIVIDIR("/", 4) {
        @Override
        public CalculadoraStrategy obterOperacao() {
            return new Dividir();
        }
    };

    CalculadoraEnum(String simbolo, int codigo) {
        this.simbolo = simbolo;
        this.codigo = codigo;
    }

    private final String simbolo;
    private final int codigo;

    public abstract CalculadoraStrategy obterOperacao();

    public static CalculadoraEnum obterCalculadoraEnum(int codigo) {
        return Arrays.stream(CalculadoraEnum.values())
                .filter(s -> s.getCodigo() == codigo)
                .findFirst().orElseThrow(() -> new CalculadoraException("Código inválido"));
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return this.simbolo;
    }
}
