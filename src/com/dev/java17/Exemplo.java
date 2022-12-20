package com.dev.java17;

import java.math.BigDecimal;

public class Exemplo {

    public static void main(String[] args) {
//        textBlockExemple();
//        patternMatching(5);
//        patternMatching("cinco");
        recordsExample();
        System.out.println(converter("2"));
        System.out.println(converter(true));
        System.out.println(converter(null));
        System.out.println(expressoesSwitch(DiasEnum.QUINTA));
        System.out.println(expressoesSwitch(DiasEnum.DOMINGO));
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

    private static Double converter(Object obj) {
        return switch (obj) {
            case String s -> Double.parseDouble(s);
            case Integer i -> i.doubleValue();
            case null -> 0d;
            default -> 0d;
        };
    }

    private static String expressoesSwitch(DiasEnum dia) {
        return switch (dia) {
            case DOMINGO , SABADO -> "Final de semana";
            default -> "Dia útil";
        };
    }

}
