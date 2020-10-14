package com.dev.models;

import java.util.Optional;

public class Caminhao {

	private String modelo;
	private Seguro seguro;

	public Caminhao(String modelo, Seguro seguro) {
		super();
		this.modelo = modelo;
		this.seguro = seguro;
	}

	public Caminhao() {

	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Optional<Seguro> getSeguro() {
		return Optional.ofNullable(seguro);
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
}
