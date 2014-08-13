package br.com.testeAngular;

public class Person {
	private String nome;
	private String idade;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String nome, String idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

}
