package com.dev.models;

import java.util.Optional;

public class Motorista {
	private String nome;
	private Integer idade;
	private Caminhao caminhao;

	public Motorista(String nome, Integer idade, Caminhao caminhao) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.caminhao = caminhao;
	}

	public Motorista() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Optional<Caminhao> getCaminhao() {
		return Optional.ofNullable(caminhao);
	}

	public void setCaminhao(Caminhao caminhao) {
		this.caminhao = caminhao;
	}

	@Override
	public String toString() {
		return "Motorista{" +
				"nome='" + nome + '\'' +
				", idade=" + idade +
				", caminhao=" + caminhao +
				'}';
	}
}
