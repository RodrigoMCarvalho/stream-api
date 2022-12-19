package com.dev.java17;

import java.math.BigDecimal;

public class Exemplo {

    public static void main(String[] args) {
//        textBlockExemple();
//        patternMatching(5);
//        patternMatching("cinco");
        recordsExample();
    }

    public static void textBlockExemple() {
        String beforeQuery = "update products\n" +
                "set quantityInStock = ?\n" +
                ",modifieldDate = ?\n" +
                ",modifieldBy = ?\n" +
                "where productCode = ?\n";
        System.out.println(beforeQuery);
        String query = """
                update products
                set quantityInStock = ?
                ,modifieldDate = ?
                ,modifieldBy = ?
                where productCode = ?
                """;
        System.out.println(query);
    }

    public static void patternMatching(Object num) {
        if (num instanceof Integer n &&  n > 0) {
            //Integer n = (Integer) num;
            System.out.println(n);
        }
    }

    public static void recordsExample() {
       ProdutoRecord produtoRecord = new ProdutoRecord(1l, "Produto1", BigDecimal.TEN);
        System.out.println(produtoRecord);

        record Temporaria(String nome){};
        Temporaria temp = new Temporaria("Temporaria");
        System.out.println(temp.nome);

        interface MinhaInterface{};

        enum DIAS {DOMINGO, SEGUNDA};

        System.out.println(DIAS.DOMINGO);
    }

}
