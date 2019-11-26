package com.dev.models;

public class Funcionario {
	String nome;
	Boolean ativo;
	Double salario;
	
	public Funcionario(String nome,Boolean ativo) {
		this.nome = nome;
		this.ativo = ativo;
	}
	public Funcionario(String nome,Double salario) {
		this.nome = nome;
		this.salario = salario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", ativo=" + ativo + ", salario=" + salario + "]";
	}
	
	
}
