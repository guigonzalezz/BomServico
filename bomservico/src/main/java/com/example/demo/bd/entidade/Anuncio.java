package com.example.demo.bd.entidade;

public class Anuncio {

	private int id;
	private int tipo_servico_id;
	private int user_id;
	private String descricao;
	private String titulo;
	
	public Anuncio() {
		super();
	}
	public Anuncio(int id, int tipo_servico_id, int user_id, String descricao, String titulo) {
		super();
		this.id = id;
		this.tipo_servico_id = tipo_servico_id;
		this.user_id = user_id;
		this.descricao = descricao;
		this.titulo = titulo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo_servico_id() {
		return tipo_servico_id;
	}
	public void setTipo_servico_id(int tipo_servico_id) {
		this.tipo_servico_id = tipo_servico_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
