package com.bomservico.model;



public class Anuncio {

	private Long id;
	private String descricao;
	private String titulo;
	private Usuario usuario;
	private TipoServico tipo_servico;


	public Anuncio() {
	}

	public Anuncio(Long id, String titulo, String descricao, Usuario usuario,
			TipoServico tipo_servico) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.usuario = usuario;
		this.tipo_servico = tipo_servico;
	}
	

	public Anuncio(String titulo, String descricao, Usuario usuario,
			TipoServico tipo_servico) {
		super();
		this.descricao = descricao;
		this.titulo = titulo;
		this.usuario = usuario;
		this.tipo_servico = tipo_servico;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
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



	public TipoServico getTipo_servico() {
		return tipo_servico;
	}



	public void setTipo_servico(TipoServico tipo_servico) {
		this.tipo_servico = tipo_servico;
	}




}
