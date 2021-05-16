package com.example.demo.bd.entidade;

public class TIpoServico {

	private int id;
	private String nome;
		
	public TIpoServico() {
		super();
	}
	public TIpoServico(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
