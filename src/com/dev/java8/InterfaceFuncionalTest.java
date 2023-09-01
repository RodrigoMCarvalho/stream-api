package com.dev.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class InterfaceFuncionalTest {

    public static void main(String[] args) {

        Stream.generate(() -> new Random().nextInt()) //SUPPLIER - Nao recebe valor e retorna um valor
                .limit(5)
                .forEach(System.out::println); //CONSUMER - Recebe um valor, faz alguma coisa com ele e nao retorna nada

        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
        lista.stream()
                .filter(e -> e % 2 == 0) //PREDICATE - Funcao que recebe um valor e retorna um boleano (UM TESTE)
                .map(Integer::doubleValue) //FUNCTION - Recebe um valor e retorna um outro valor, podendo ser tipos diferentes
                .reduce(Double::sum) //BIUNARYOPERATOR - Recebe dois valores do stream e retorna um outro, sendo do mesmo tipo
                .ifPresent(System.out::println);


        Map<String, Integer> idades = new HashMap<>();
        idades.put("Gustavo", 9);
        idades.put("Rodrigo", 30);
        idades.put("Raquel", 28);
        BiConsumer<String, Integer> printIdade = (nome, idade) -> System.out.println(nome + " tem " + idade + " anos.");
        idades.forEach(printIdade);

        BiConsumer<String, Integer> valores = (key, value) -> System.out.println(key + " - " + value);
        valores.accept("Gustavo", 9);

        BiConsumer<Integer, Integer> operacoes = (a, b) -> {
            System.out.println("Soma: " + (a + b));
            System.out.println("Subtração: " + (a - b));
            System.out.println("Multiplicação: " + (a * b));
        };
        operacoes.accept(10, 5);

        BiConsumer<String, String> printConcatenado = (str1, str2) -> {
            System.out.println("Concatenado: " + str1 + str2);
            System.out.println("Uppercase: " + str1.toUpperCase() + " " + str2.toUpperCase());
        };
        printConcatenado.accept("Rodrigo", "Moreira");

        Map<String, String> nameMap = new HashMap<>();
        nameMap.computeIfAbsent("rodrigo", String::toUpperCase);
        nameMap.forEach((p1, p2) -> System.out.println(p1 + " - " + p2));

        Map<String, Integer> salarios = new HashMap<>();
        salarios.put("Romario", 450000);
        salarios.put("Ronaldo", 600000);
        salarios.put("Edmundo", 255000);
        salarios.put("Ronaldinho", 80000);
        List<String> jogadoresQNaoTeraoAumento = List.of("Romario", "Ronaldo");
        salarios.replaceAll((nome, oldSalario) -> (jogadoresQNaoTeraoAumento.contains(nome)) ? oldSalario : oldSalario + 10000);
        salarios.forEach((nome, salario) -> System.out.println(nome + " - " + salario));
    }
}
