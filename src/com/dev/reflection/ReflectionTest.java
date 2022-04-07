package com.dev.reflection;

import com.dev.models.Motorista;
import com.dev.models.Pessoa;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class<?> classe = Class.forName(Motorista.class.getName());
        System.out.println("Caminho da classe: " + classe);
        System.out.println("Nome da classe: " + classe.getSimpleName());

        Constructor<?>[] construtores = classe.getDeclaredConstructors();
        for (Constructor<?> construtor : construtores) {
            System.out.println("Construtor: " + construtor);
        }

        Method[] metodos = classe.getDeclaredMethods();

        for (Method metodo : metodos) {
            System.out.println("Metodo: " + metodo);
        }

        List<String> nomesAtributos = Arrays.stream(Motorista.class.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());

        List<String> nomesPrimeiraLetraMaiuscula =  nomesAtributos.stream()
                .map(l -> l.replaceFirst(l.substring(0,1), l.substring(0,1).toUpperCase()))
                .collect(Collectors.toList());

        nomesPrimeiraLetraMaiuscula.forEach(System.out::println);

        Pessoa pessoa = new Pessoa("Rodrigo", 20);
        Class<?> classePessoa = Class.forName(Pessoa.class.getName());
        Field nome = classePessoa.getDeclaredField("nome");
        nome.setAccessible(true);  //Devido ao atributo nome ser privado
        nome.set(pessoa, "Gustavo");
        System.out.println("Novo valor do atributo: " + pessoa);
    }
}
