package teste;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {

		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("Diana", 25),
				new Pessoa("Bruce", 45), 
				new Pessoa("Hall", 29), 
				new Pessoa("Bel", 20),
				new Pessoa("Bolan", 20));

		int soma = pessoas.stream()
				.filter(p -> p.getNome().startsWith("B"))
				.mapToInt(p -> p.getIdade()).sum();

		System.out.println(soma);

		IntSummaryStatistics statistics = pessoas.stream()
				.filter(p -> p.getNome().startsWith("B"))
				.mapToInt(p -> p.getIdade()).summaryStatistics();

		System.out.println("Soma: " + statistics.getSum());
		System.out.println("M�dia: " + statistics.getAverage());
		System.out.println("Maior: " + statistics.getMax());
		System.out.println("Menor: " + statistics.getMin());
		
		List<Pessoa> listPessoas = pessoas.stream()
				.filter(p -> p.getNome().startsWith("B"))
				.collect(Collectors.toList());
		
		Map<Integer, List<Pessoa>> mapPessoas = listPessoas.stream()
				.collect(Collectors.groupingBy(Pessoa::getIdade));
		
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
		
		System.out.println("Lista de n�meros");
		List<Integer>listNum = Arrays.asList(5, 9, 4, 16, 2, 21, 3);
		listNum.forEach(System.out::println);
		
		System.out.println("Lista de n�meros ordenados");
		List<Integer> listSorted = listNum.stream()
				.sorted()
				.collect(Collectors.toList());
		listSorted.forEach(System.out::println);
		
		pessoas.forEach(System.out::println);
		System.out.println("Lista de pessoas ordenados por idade");
		
		java.util.stream.Stream<Pessoa> pessoasSorted = pessoas.stream()
				.sorted(Comparator.comparingInt(Pessoa::getIdade));
		java.util.stream.Stream<Pessoa> pessoasSortedInverso = pessoas.stream()
				.sorted(Comparator.comparingInt(Pessoa::getIdade).reversed());
		pessoasSorted.forEach(System.out::println);
		
		//Usando REDUCE ------------------------------------------------------------------------
		// O valor 0 � o valor de identidade, iniciando o valor parcial da fun��o e 
		// ser� o valor final da opera��o caso os valores para redu��o seja vazio. 
		// Ainda temos o subtotal que � o valor acumulador da redu��o e o element que � o valor combinador.
		List<Integer> numeros = Arrays.asList(2, 9, 16, 20);
		Integer reduce = numeros.stream()
			.reduce(0, (subtotal, element) -> subtotal + element);
		System.out.println("Soma dos n�meros: " + reduce);
		
		Integer reduce2 = numeros.stream()
			.reduce(0, Integer::sum);
		System.out.println("Soma dos n�meros2: " + reduce2);

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
		
		// Criar uma nova lista de usu�rios ativos e imprimir usando java 8 e forEach
		funcionarios.stream()
			.filter(funcionario -> funcionario.ativo)
			.forEach(u -> System.out.println("Usu�rio ativo: " + u.nome));
		
		funcionarios.stream()
			.filter(funcionario -> funcionario.ativo == false)
			.forEach(u -> System.out.println("Usu�rio desativado: " + u.nome));
		
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
			.forEach(f -> System.out.println(f.salario * 5 /100));
		
		
		
		
		
		
		
		
		
		
		
	}

}
