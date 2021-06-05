package lp3.bomservico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequisicaoNovoTipoServico {
	
	@NotBlank
	private String nome;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
