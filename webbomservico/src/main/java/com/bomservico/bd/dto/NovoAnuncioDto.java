package com.bomservico.bd.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bomservico.model.Anuncio;
import com.bomservico.model.TipoServico;
import com.bomservico.model.Usuario;


public class NovoAnuncioDto {

	private static DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 15, message = "minimo 15 caracteres")
	private String descricao;

	@NotNull
	@NotBlank
	@Size(min = 8, message = "minimo 8 caracteres")
	private String titulo;
	
	@NotNull
	private Usuario usuario;
	
	@NotNull
	private TipoServico tipo_servico;


	public NovoAnuncioDto(Anuncio anuncio) {
		this.id = anuncio.getId();
		this.descricao = anuncio.getDescricao();
		this.titulo = anuncio.getTitulo();
		this.usuario = anuncio.getUsuario();
		this.tipo_servico = anuncio.getTipo_servico();
	}

	public NovoAnuncioDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoServico getTipo_servico() {
		return tipo_servico;
	}

	public void setTipo_servico(TipoServico tipo_servico) {
		this.tipo_servico = tipo_servico;
	}

	public Anuncio toAnuncio() {
		Anuncio anuncio = new Anuncio(titulo, descricao, usuario, tipo_servico);
		anuncio.setId(id);
		return anuncio;
	}

}
