package com.dev.models;

import java.util.*;

public class Cliente {

    private String nome;
    private List<TipoCliente> tipoClientes;

    public Cliente(String nome, List<TipoCliente> tipoClientes) {
        this.nome = nome;
        this.tipoClientes = tipoClientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TipoCliente> getTipoClientes() {
        return tipoClientes;
    }

    public void setTipoClientes(List<TipoCliente> tipoClientes) {
        this.tipoClientes = tipoClientes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipoClientes=" + tipoClientes +
                '}';
    }
}
