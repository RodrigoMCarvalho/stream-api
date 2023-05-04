package com.dev.models;

import java.util.List;

public class Cesta {

    private List<Fruta> frutas;

    public Cesta(List<Fruta> frutas) {
        this.frutas = frutas;
    }

    public List<Fruta> getFrutas() {
        return frutas;
    }

    public void setFrutas(List<Fruta> frutas) {
        this.frutas = frutas;
    }

    @Override
    public String toString() {
        return "Cesta{" +
                "frutas=" + frutas +
                '}';
    }
}
