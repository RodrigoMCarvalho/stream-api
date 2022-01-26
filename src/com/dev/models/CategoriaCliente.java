package com.dev.models;

public class CategoriaCliente {

    private String nome;
    private String flAtivo;
    private Integer valor;

    public CategoriaCliente(String nome, String flAtivo, Integer valor) {
        this.nome = nome;
        this.flAtivo = flAtivo;
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getFlAtivo() {
        return flAtivo;
    }

    public void setFlAtivo(String flAtivo) {
        this.flAtivo = flAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CategoriaCliente{" +
                "nome='" + nome + '\'' +
                ", flAtivo='" + flAtivo + '\'' +
                ", valor=" + valor +
                '}';
    }
}
