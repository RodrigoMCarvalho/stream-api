package com.dev.java8;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import com.dev.Motoristas;
import com.dev.models.Caminhao;
import com.dev.models.Motorista;
import com.dev.models.Seguro;

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
		optional.ifPresent(n -> System.out.println(n));
		
		//Simplificando
		converterEmNumero(string).ifPresent(n -> System.out.println(n));
		
		String s = "9";  //se consegue converter String para Integer, imprime o valor
		//String s = "valor"; //se não consegue converter, imprime 2
		Integer n = converterEmNumero(s).orElse(2);
		System.out.println(n);
		
		Integer n2 = converterEmNumero(s).orElseGet(() -> 5);
		System.out.println(n2);
		
		Stream.of().findFirst().ifPresent(System.out::println);

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
