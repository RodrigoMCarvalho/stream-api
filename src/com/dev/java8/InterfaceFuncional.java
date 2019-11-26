package com.dev.java8;

import java.util.stream.Stream;
import java.util.*;


public class InterfaceFuncional {

	public static void main(String[] args) {
		
		Stream.generate(() -> new Random().nextInt()) //SUPPLIER - Não recebe valor e retorna um valor
			.limit(5)
			.forEach(e -> System.out.println(e)); //CONSUMER - Recebe um valor, faz alguma coisa com ele e não retorna nada
		
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
		lista.stream()
			.filter(e -> e % 2 == 0) //PREDICATE - Função que recebe um valor e retorna um boleano (UM TESTE)
			.map(e -> e.doubleValue()) //FUNCTION - Recebe um valor e retorna um outro valor, podendo ser tipos diferentes
			.reduce((n1, n2) -> n1 + n2) //BIUNARYOPERATOR - Recebe dois valores do stream e retorna um outro, sendo do mesmo tipo
			.ifPresent(System.out::println);
	}
}
