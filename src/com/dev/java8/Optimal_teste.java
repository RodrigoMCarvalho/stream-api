package com.dev.java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dev.models.*;

public class Optimal_teste {

	public static void main(String[] args) {
//		Motoristas motoristas = new Motoristas();
//		Motorista motorista = motoristas.porNome("José");
//		String cobertura = motorista.getCaminhao().getSeguro().getCobertura();
//		cobertura = cobertura != null ? cobertura : "Sem seguro";
//		
//		System.out.println(cobertura);

		Seguro seguro = new Seguro("Total cobertura", new BigDecimal("600"));
		Optional<Seguro> seguroOpt = Optional.ofNullable(seguro);

		seguroOpt.map(Seguro::getValorFranquia)
				.ifPresent(System.out::println);

		Motoristas motoristas = new Motoristas();
		Optional<Motorista> motoristaOpt = motoristas.porNome("João");

		Optional<Motorista> motoristaOpt2 = motoristas.porNome("Josésss"); //tomará um NullPointer

		Optional<Optional<Motorista>> optional2 = Optional.ofNullable(motoristaOpt2);
		optional2.ifPresent(n -> System.out.println(n.get()));

		//System.out.println(motoristaOpt2.get().getCaminhao()); tomará um NullPointer

//		Optional<Caminhao>caminhaoOpt = motoristaOpt.map(Motorista::getCaminhao);
//		Optional<String>caminhaoOpt = motoristaOpt
//				.flatMap(Motorista::getCaminhao)
//				.flatMap(Caminhao::getSeguro)
//				.map(Seguro::getCobertura);
//		caminhaoOpt.ifPresent(System.out::println);

		String cobertura = motoristaOpt
				.flatMap(Motorista::getCaminhao)
				.flatMap(Caminhao::getSeguro)
				.map(Seguro::getCobertura)
				.orElse("Sem seguro");
		System.out.println(cobertura);


		String string = "Optiona Java 8";
		Optional<Integer> optional = converterEmNumero(string);
		//System.out.println(optional.get());  Ainda pode tomar uma Exception com get
		optional.ifPresent(System.out::println);

		//Simplificando
		converterEmNumero(string).ifPresent(System.out::println);

		String s = "9";  //se consegue converter String para Integer, imprime o valor
		//String s = "valor"; //se não consegue converter, imprime 2
		Integer n = converterEmNumero(s).orElse(2);
		System.out.println(n);

		Integer n2 = converterEmNumero(s).orElseGet(() -> 5);
		System.out.println(n2);

		Stream.of().findFirst().ifPresent(System.out::println);

		Integer valor = 9;
		Integer valorFinal = Optional.ofNullable(valor).map(v -> v * 2).orElse(10);
		System.out.println(valorFinal);

		//FIXME: Converter array para lista
		Optional<Funcionario[]> fun = Optional.ofNullable(null);
		fun.map(Arrays::asList).orElse(Collections.emptyList());

		var funcionario = new Funcionario();
		funcionario.setNome("Rodrigo");
		funcionario = null;
		System.out.println(Objects.nonNull(funcionario) ? funcionario.getNome() : null);

		Optional.ofNullable(funcionario).ifPresentOrElse(f -> System.out.println(f.getNome()), () -> System.out.println("Vazio"));

		List<Integer> status = Arrays.asList(2, 6, 8, 10);

		List<Integer> status2 = null;  //Para testar obj nulo

		String statusString = Optional.ofNullable(status)
				.orElseGet(Collections::emptyList).stream()
				.map(Object::toString)
				.collect(Collectors.joining(","));

		System.out.println(statusString);

		Seguro seguro1 = new Seguro();
		String cobertura1 = null;
		BigDecimal valor1 = null;
		//seguro1.setCobertura(Objects.requireNonNullElse(cobertura1, "Cobertura padrão"));
//		seguro1.setValorFranquia(Objects.requireNonNullElse(valor1, BigDecimal.ZERO));
		seguro1.setCobertura(Optional.ofNullable(cobertura1).orElse("Cobertura padrão optiomal"));
		seguro1.setValorFranquia(Optional.ofNullable(valor1).orElse(BigDecimal.ZERO));
		System.out.println(seguro1);

		List<Pessoa> pessoas = (List.of(new Pessoa("Rodrigo", 20), new Pessoa("Gustavo", 20)));
		List<Pessoa> pessoasNulo = null;

		if (Objects.nonNull(pessoasNulo)) {
			boolean nome = pessoasNulo.stream().map(Pessoa::getNome).anyMatch(p -> p.equals("Rodrigo"));
		}

		boolean nome1 = Optional.ofNullable(pessoas)
				.map(Collection::stream)
				.orElseGet(Stream::empty)
				.anyMatch(p -> p.getNome().equals("Rodrigo"));

		boolean nome2 = Optional.ofNullable(pessoasNulo)
				.map(Collection::stream)
				.orElseGet(Stream::empty)
				.anyMatch(p -> p.getNome().equals("Rodrigo"));

		System.out.println("Nome1 " + nome1);
		System.out.println("Nome2 " + nome2);

		Optional<Pessoa> p1 = Optional.ofNullable(pessoas)
				.map(Collection::stream)
				.orElseGet(Stream::empty)
				.filter(p -> p.getNome().equals("Rodrigo")).findFirst();

		Optional<Pessoa> p2 = Optional.ofNullable(pessoasNulo)
				.map(Collection::stream)
				.orElseGet(Stream::empty)
				.filter(p -> p.getNome().equals("Rodrigo")).findFirst();

		p1.ifPresent(pessoa -> {
			pessoa.setIdade(35);
		});

		p2.ifPresent(pessoa -> {
			pessoa.setIdade(65);
		});

		p1.ifPresent(System.out::println);
		p2.ifPresent(System.out::println);

//		private void buscarProtocoloElegivelReutilizacao(List<ProtocoloDiaResponse> protocolosDia, List<Long> protocolosEmUso) {
//			protocolosDia.stream()
//					.filter(protocolo -> !protocolosEmUso.contains(protocolo.getCdProtocoloCotacao()))
//					.findFirst()
//					.ifPresentOrElse(
//							this::montarRequestComProtocolo,
//							this::montarRequestSemProtocolo
//					);
//		}
//
//		private void montarRequestSemProtocolo() {
//			Não existe protocolo disponivel na lista
//		}
//
//		private void montarRequestComProtocolo(ProtocoloDiaResponse protocoloDisponivel) {
//			Quanto tem protocolo disponivel na lista
//		}

	}
	public static Optional<Integer>	converterEmNumero(String numeroStr) {
		try {
			Integer numero = Integer.valueOf(numeroStr);
			return Optional.of(numero);
		} catch (Exception e) {
			return Optional.empty();
		}
	}
		
				
				
				
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
