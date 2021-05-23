package com.bomservico.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TipoServico {

	private Long id;
	private String nome;

	public TipoServico() {
		super();
	}

	public TipoServico(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
