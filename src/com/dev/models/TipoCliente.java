package com.dev.models;

import java.util.*;

public class TipoCliente {

    private String nome;
    private List<CategoriaCliente> categoriaClienteList;

    public TipoCliente(String nome, List<CategoriaCliente> categoriaClienteList) {
        this.nome = nome;
        this.categoriaClienteList = categoriaClienteList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CategoriaCliente> getCategoriaClienteList() {
        return categoriaClienteList;
    }

    public void setCategoriaClienteList(List<CategoriaCliente> categoriaClienteList) {
        this.categoriaClienteList = categoriaClienteList;
    }

    @Override
    public String toString() {
        return "TipoCliente{" +
                "nome='" + nome + '\'' +
                ", categoriaClienteList=" + categoriaClienteList +
                '}';
    }
}
