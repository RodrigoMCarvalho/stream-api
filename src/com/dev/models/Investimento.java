package com.dev.models;

public class Investimento {

    private Long ano;
    private Double valor;

    public Investimento(Long ano, Double valor) {
        this.ano = ano;
        this.valor = valor;
    }

    public Investimento() {
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ano=" + ano + ", valor=" + valor;
    }
}
