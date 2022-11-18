package com.dev.patterns;

public class MercadoEnvio implements FreteStrategy {

    public double calcularPreco(int distancia) {
        System.out.println("Modo escolhido Mercado Envio");
        return distancia * 3.50 + 6;
    }
}
