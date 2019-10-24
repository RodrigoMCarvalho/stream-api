package teste;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		System.out.println("Média: " + statistics.getAverage());
		System.out.println("Maior: " + statistics.getMax());
		System.out.println("Menor: " + statistics.getMin());
		
		List<Pessoa> listPessoas = pessoas.stream().filter(p -> p.getNome().startsWith("B"))
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
		
		
		
		
		
		
		

	}

}
