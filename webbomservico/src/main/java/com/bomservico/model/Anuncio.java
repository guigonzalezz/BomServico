package com.bomservico.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String descricao;
	
	@NotNull
	@NotBlank
	private String titulo;


	@OneToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private TipoServico tipo_servico;



	@Deprecated
	public Anuncio() {
	}

	

	public Anuncio(@NotNull @NotBlank String titulo, @NotNull @NotBlank String descricao, Usuario usuario,
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
