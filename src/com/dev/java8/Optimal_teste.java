package com.dev.java8;

import java.math.BigDecimal;
import java.util.Optional;

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
		Optional<Motorista> motoristaOpt = motoristas.porNome("Joãos");
		
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
				
		System.out.println(cobertura);;		
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
