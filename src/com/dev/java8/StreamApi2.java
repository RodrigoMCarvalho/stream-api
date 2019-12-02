package com.dev.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApi2 {

	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1, 3, 5, 6, 8, 9, 11, 12, 12, 13);
		
		lista.stream()
			.skip(2)  //Pula os 2 primeiros números
			.limit(3) //Após pular os 2 irá limitar a lista com 3 números
			.forEach(System.out::println);

		long count = lista.stream()
				.filter(e -> e % 2 == 0)
				.count();
		System.out.println("Quantos números pares na lista: " + count);
		
		long count2 = lista.stream()
			.filter(e -> e % 2 == 0)
			.distinct()
			.count();
		System.out.println("Quantos números pares distintos na lista: " + count2);
		
		Optional<Integer> min = lista.stream()
				.filter(e -> e % 2 == 0)
				.min(Comparator.naturalOrder());
		Optional<Integer> max = lista.stream()
				.filter(e -> e % 2 == 0)
				.max(Comparator.naturalOrder());
		System.out.println("Menor número PAR da lsita: " + min.get());
		System.out.println("Maior número PAR da lsita: " + max.get());
		
		List<Integer> novaLista = lista.stream()
			.filter(e -> e % 2 == 0)
			.map(e -> e * 3)
			.collect(Collectors.toList());
		System.out.println("Nova lista: " + novaLista);
		
		Map<Boolean, List<Integer>> mapaParImpar = lista.stream()//Mapa agrupado por Boleano
			.map(e -> e * 3)									//Multiplica por 3
			.collect(Collectors.groupingBy(e -> e % 2 != 0)); //Comparação, retorna um Boleano, true será os não divisíveis por 2 
		System.out.println(mapaParImpar);
		
		Map<Integer, List<Integer>> mapaResto = lista.stream() //Mapa agrupado pelo resto da divisão por 3
			.collect(Collectors.groupingBy(e -> e % 3)); //Retorna um inteiro
		System.out.println(mapaResto);
		
		
		String string = lista.stream()
			.map(e -> String.valueOf(e))  //Transforma os números em string
			.collect(Collectors.joining("-")); //Concatena os strings
		System.out.println(string);
	}

}
