package com.dev.reflection;

import com.dev.models.Motorista;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionTest {

    public static void main(String[] args) {

        List<String> nomesAtributos = Arrays.stream(Motorista.class.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());

        List<String> nomesPrimeiraLetraMaiuscula =  nomesAtributos.stream()
                .map(l -> l.replaceFirst(l.substring(0,1), l.substring(0,1).toUpperCase()))
                .collect(Collectors.toList());

        nomesPrimeiraLetraMaiuscula.forEach(System.out::println);
    }
}
