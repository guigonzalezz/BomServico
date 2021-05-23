package com.bomservico.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TipoServico {

	@NotNull
	private int id;

	@NotNull
	@NotBlank
	private String nome;

	public TipoServico() {
		super();
	}

	public TipoServico(@NotNull int id, @NotNull @NotBlank String nome) {
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
