package com.dev.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dev.models.Funcionario;
import com.dev.models.Pessoa;

public class StreamApi {

	public static void main(String[] args) {

		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("Diana", 25),
				new Pessoa("Bruce", 45), 
				new Pessoa("Hall", 29), 
				new Pessoa("Bel", 20),
				new Pessoa("Bolan", 20));

		int soma = pessoas.stream()
				.filter(p -> p.getNome().startsWith("B"))
				.mapToInt(p -> p.getIdade())
				.sum();

		System.out.println(soma);

		IntSummaryStatistics statistics = pessoas.stream()
				.filter(p -> p.getNome().startsWith("B"))
				.mapToInt(p -> p.getIdade())
				.summaryStatistics();

		System.out.println("Soma: " + statistics.getSum());
		System.out.println("Média: " + statistics.getAverage());
		System.out.println("Maior: " + statistics.getMax());
		System.out.println("Menor: " + statistics.getMin());
		
		List<Pessoa> listPessoas = pessoas.stream()
				.filter(p -> p.getNome().startsWith("B"))
				.collect(Collectors.toList());
		
		Map<Integer, List<Pessoa>> mapPessoas = listPessoas.stream() //Lista de Pessoas
				.collect(Collectors.groupingBy(Pessoa::getIdade));  //Retorna um inteiro
		
		mapPessoas.get(20).forEach(p -> System.out.println(p.getNome()));
		
		listPessoas.stream()
			.collect(Collectors.groupingBy(Pessoa::getIdade))
			.get(45)
			.forEach(p -> System.out.println("Quem tem 45 anos: " + p.getNome()));
		
		
		Optional<Pessoa> optPessoal = listPessoas.stream()
				.filter(p -> p.getIdade() > 30)
				.findFirst();
		
		if(optPessoal.isPresent()) {
			System.out.println(optPessoal.get().getIdade());
		}
		optPessoal.ifPresent(p -> System.out.println(p.getIdade()));
		
		System.out.println("Lista de números");
		List<Integer>listNum = Arrays.asList(5, 9, 4, 16, 2, 21, 3);
		listNum.forEach(System.out::println);
		
		System.out.println("Lista de números ordenados");
		List<Integer> listSorted = listNum.stream()
				.sorted()
				.collect(Collectors.toList());
		listSorted.forEach(System.out::println);
		
		pessoas.forEach(System.out::println);
		System.out.println("Lista de pessoas ordenados por idade");
		
		Stream<Pessoa> pessoasSorted = pessoas.stream()
				.sorted(Comparator.comparingInt(Pessoa::getIdade));
		pessoas.stream()
				.sorted(Comparator.comparingInt(Pessoa::getIdade).reversed());
		pessoasSorted.forEach(System.out::println);
		
		//Usando REDUCE ------------------------------------------------------------------------
		// O valor 0 é o valor de identidade, iniciando o valor parcial da função e
		// será o valor final da operação caso os valores para redução seja vazio.
		// Ainda temos o subtotal que é o valor acumulador da redução e o element que é o valor combinador.
		List<Integer> numeros = Arrays.asList(2, 9, 16, 20);
		Integer reduce = numeros.stream()
			.reduce(0, (subtotal, element) -> subtotal + element);
		System.out.println("Soma dos números: " + reduce);
		
		Integer reduce2 = numeros.stream()
			.reduce(0, Integer::sum);
		System.out.println("Soma dos númeross2: " + reduce2);

		List<String> palavras = Arrays.asList("Como", " usar", " reduce", " para", " juntar", " strings");
		String reduce3 = palavras.stream()
			.reduce("", (partialString , element) -> partialString + element);
		System.out.println(reduce3);
		
		String reduce4 = palavras.stream()
			.reduce("", String::concat);
		System.out.println(reduce4);
		
		//------------------------------------------------------
		
		List<Funcionario> funcionarios = Arrays.asList(
				new Funcionario("Edmundo", true),
				new Funcionario("Romario", true),
				new Funcionario("Bebeto", false),
				new Funcionario("Renato", false));
		
		// Criar uma nova lista de usuários ativos e imprimir usando java 8 e forEach
//		funcionarios.stream()
//			.filter(f -> f.)
//			.forEach(u -> System.out.println("Usuário ativo: " + u.nome));
		funcionarios.stream()
			.filter(f -> f.getAtivo())
			.forEach(u -> System.out.println("Usuário ativo: " + u.getNome()));
		
		funcionarios.stream()
			.filter(funcionario -> funcionario.getAtivo() == false)
			.forEach(u -> System.out.println("Usuário desativado: " + u.getNome()));
		
		// transformar todos os paises para letras maiusculas e concatenar em uma string utilizando join por , com java 8
		List<String> paises = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		List<String> paisesMaiusculo = paises.stream()
			.map(p -> p.toUpperCase())
			.collect(Collectors.toList());
		System.out.println(String.join(",", paisesMaiusculo) );
		
		List<Funcionario> func = Arrays.asList(
				new Funcionario("Cesar", 2.589),
				new Funcionario("Maria", 1.800));
		func.stream()
			.forEach(f -> System.out.println(f.getSalario() * 5 /100));
		
		
		pessoas.stream()
			.filter(e -> e.getNome()
			.startsWith("D"))
			.forEach(System.out::println);
		
		System.out.println("---------------");
		
		pessoas.stream()
			.filter(e -> e.getIdade() == 20)
			.forEach(System.out::println);;
		
		System.out.println("---------------");	
		
//		for (Pessoa p : pessoas) {
//			if(p.getIdade() == 29){
//				p.setIdade(90);
//			}
//		}
//		pessoas.forEach(System.out::println);
		
		pessoas.stream()
			.map( e -> {
				if (e.getIdade() == 29) {
					 e.setIdade(90);
				}return e;
			}).forEach(System.out::println);

		System.out.println("---------------------------- Outra forma de modificar uma lista");

		pessoas.stream()
				.filter(e -> e.getIdade() == 20)
				.forEach(e -> e.setIdade(91));

		pessoas.forEach(System.out::println);

		System.out.println("---------------------------- Funcionarios");

		List<Funcionario> funcionarioList = pessoas.stream().map(pessoa -> {
			var funcionario = new Funcionario();
			funcionario.setNome(pessoa.getNome());
			funcionario.setAtivo(true);
			funcionario.setSalario(retornaSalario(pessoa.getIdade()));
			return funcionario;
		}).collect(Collectors.toList());

		funcionarioList.forEach(System.out::println);
	}

	private static Double retornaSalario(int idade) {
		return idade > 50 ? 8500.0 : 5500.0;
	}
}
