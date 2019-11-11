package teste;

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
}
