package com.dev.patterns;

import java.math.BigDecimal;

import static java.lang.System.out;

public class Strategy {

    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal("10");
        String nome = "Rodrigo";
        Compra compra = new Compra(valor, nome);
        compra.processarCompra(new PagamentoCartaoDebito());
//        compra.processarCompra(v -> out.println("Pagou no credito " + v.getValor()));
    }
}

//Contexto
class Compra {

    BigDecimal valor;
    String nome;

    public Compra(BigDecimal valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    void processarCompra(PagamentoStrategy pagamentoStrategy){
        pagamentoStrategy.pagar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }
}

interface PagamentoStrategy{
    void pagar(Compra compra);
}

//Strategy Concreta
class PagamentoCartaoDebito implements PagamentoStrategy{
    @Override
    public void pagar(Compra compra) {
        out.println(String.format("%s pagou no debito o valor de R$%s", compra.getNome(), compra.getValor()));
    }
}

//Strategy Concreta
class PagamentoCartaoCredito implements PagamentoStrategy{
    @Override
    public void pagar(Compra compra) {
        out.println(String.format("%s pagou no credito o valor de R$%s", compra.getNome(), compra.getValor()));
    }
}
