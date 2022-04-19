package com.dev.java8;

import com.dev.models.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		System.out.println("Menor número PAR da lista: " + min.get());
		System.out.println("Maior número PAR da lista: " + max.get());
		
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

		System.out.println("Date: " + new Date());

		List<String> paises = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		paises.stream().sorted().forEach(System.out::println);

		List<Funcionario> funcionarios = Arrays.asList(new Funcionario("Rodrigo", false),
				new Funcionario("Mario", false),
				new Funcionario("Jorge", false),
				new Funcionario("Gustavo", false),
				new Funcionario("Alex", false),
				new Funcionario("Zulu", false),
				new Funcionario("Carlos", false));

		funcionarios.stream()
				.sorted(Comparator.comparing(Funcionario::getNome))
				.forEach(System.out::println);

		List<String> nordeste = Arrays.asList("Bahia", "Ceará", "Maranhão", "Piauí");
		List<String> sudeste = Arrays.asList("Rio de janeiro", "São Paulo", "Minas Gerais", "Espirito Santo");
		List<String> sul = Arrays.asList("Rio Grande do sul", "Santa Catarina", "Paraná");

		System.out.println("-----Juntando listas Stream.of ---------");
		Stream.of(nordeste,sudeste,sul)
				.flatMap(Collection::stream)
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("-----Juntando listas Stream.concat (3 listas)---------");
		Stream.concat(Stream.concat(nordeste.stream(),sudeste.stream()), sul.stream())
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out::println);

		System.out.println("-----Juntando listas Stream.concat (2 listas)---------");
		Stream.concat(nordeste.stream(),sudeste.stream())
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out::println);

		List<String> frutas1 = Arrays.asList("banana", "melancia", "morango", "banana");
		List<String> frutas2 = Arrays.asList("abacaxi", "maracujá", "morango", "banana");

		System.out.println("-----Juntando listas de frutas distintas---------");
		Stream.of(frutas1,frutas2)
				.flatMap(Collection::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out::println);

		CategoriaCliente categoriaCliente = new CategoriaCliente("categoria1", "S", null);
		CategoriaCliente categoriaCliente2 = new CategoriaCliente("categoria2", "S", null);
		CategoriaCliente categoriaCliente3 = new CategoriaCliente("categoria3", "N", null);

		CategoriaCliente categoriaCliente4 = new CategoriaCliente("categoria4", "N", null);
		CategoriaCliente categoriaCliente5 = new CategoriaCliente("categoria5", "N", null);
		CategoriaCliente categoriaCliente6 = new CategoriaCliente("categoria6", "S", null);

		List<CategoriaCliente> categoriaList = List.of(categoriaCliente, categoriaCliente2, categoriaCliente3);
		List<CategoriaCliente> categoriaList2 = List.of(categoriaCliente4, categoriaCliente5, categoriaCliente6);

		TipoCliente tipoCliente = new TipoCliente("tipo1", categoriaList);
		TipoCliente tipoCliente2 = new TipoCliente("tipo2", categoriaList2);

		List<TipoCliente> tipos = List.of(tipoCliente, tipoCliente2);

		Cliente cliente = new Cliente("Cliente1", tipos);

//		for (TipoCliente tipo : cliente.getTipoClientes()) {
//			for (CategoriaCliente categoria : tipo.getCategoriaClienteList()) {
//				if(categoria.getFlAtivo().equals("S")) {
//					categoria.setValor(10);
//				} else {
//					categoria.setValor(30);
//				}
//			}
//		}
		cliente.getTipoClientes().stream()
				.flatMap(tipo -> tipo.getCategoriaClienteList().stream())
				.forEach(categoria -> categoria.setValor(categoria.getFlAtivo().equals("S") ? 10 : 30));
		System.out.println(cliente);

		cliente.getTipoClientes().stream()
				.flatMap(tipo -> tipo.getCategoriaClienteList().stream())
				.map(CategoriaCliente::getNome)
				.forEach(System.out::println);
				//.collect(Collectors.toList());

		System.out.println(String.format("Lista original: %s", sudeste));

		Collections.shuffle(sudeste);
		System.out.println(String.format("Lista embaralhada: %s", sudeste));

		Collections.sort(sudeste);
		System.out.println(String.format("Lista ordenada: %s", sudeste));

		Collections.reverse(sudeste);
		System.out.println(String.format("Lista reversa: %s", sudeste));

		List<Integer> list = Arrays.asList(1,2,3,4);
		list.stream()
				.sorted(Collections.reverseOrder())
				.forEach(System.out::println);

		System.out.println("----Original----");
		sul.stream().forEach(System.out::println);

		System.out.println("----Inversa----");
		sul.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		System.out.println("----Ordenda----");
		sul.stream().sorted().forEach(System.out::println);

//        var variavel = "S";
//        if(variavel.equals("S")) {
//            System.out.println("sim");
//        } else if (variavel.equals("N")) {
//            System.out.println("não");
//        } else if (variavel.equals("T")) {
//            System.out.println("talvez");
//        } else if (variavel.equals("E")) {
//            System.out.println("error");
//        } else {
//            System.out.println("não encontrado");
//        }

        System.out.println(TipoEnum.obterValue("S"));
        System.out.println(TipoEnum.obterValue("N"));
        System.out.println(TipoEnum.obterValue("X"));

		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("Rodrigo", 19),
				new Pessoa("Gustavo", 20),
				new Pessoa("Raquel", 22));

		List<Pessoa> pessoas2 = Arrays.asList(
				new Pessoa("Rodrigo", 19),
				new Pessoa("Edmundo", 20),
				new Pessoa("Raquel", 22));


//		anyMatch  -> Retorna true se existir alguém na lista que retorna true;
//		allMatch  -> Retorna true se todos mundo na lista retornar true;
//		noneMatch -> Retorna true se todos na lista retornam false;

		System.out.println("Compara de as listas tem os mesmo nomes: " +
				pessoas.stream().map(Pessoa::getNome).allMatch(p ->
						pessoas2.stream().map(Pessoa::getNome).collect(Collectors.toList()).contains(p)));

		System.out.println(pessoas.stream().anyMatch(p -> p.getIdade() > 18));
		System.out.println(pessoas.stream().anyMatch(p -> p.getNome().startsWith("G")));

		System.out.println(pessoas.stream().allMatch(p -> p.getIdade() > 18));
		System.out.println(pessoas.stream().allMatch(p -> p.getNome().startsWith("G"))); //para retornar true, todos os nomes deveriam começar com "G"

		System.out.println(pessoas.stream().noneMatch(p -> p.getIdade() < 18));  //retornará true, pois todos na lista tem mais de 18

	}




}

