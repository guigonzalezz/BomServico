package lp3.bomservico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequisicaoNovoAnuncio {
	
	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	@NotBlank
	private String imagem;
	
	private int tipo_servico;
	
	private String user;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getTipo_servico() {
		return tipo_servico;
	}
	public void setTipo_servico(int tipo_servico) {
		this.tipo_servico = tipo_servico;
	}
	public String  getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
