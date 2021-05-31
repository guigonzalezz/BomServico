package lp3.bomservico.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "anuncio")
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String titulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@ManyToOne //Cardianilidade entre as tabelas
	private TipoServico tipo_servico;


	public Anuncio() {
	}

	public Anuncio(Long id, String titulo, String descricao, User usuario,
			TipoServico tipo_servico) {
		this.id = id;
		this.descricao = descricao;
		this.titulo = titulo;
		this.user = usuario;
		this.tipo_servico = tipo_servico;
	}
	

	public Anuncio(String titulo, String descricao, User usuario,
			TipoServico tipo_servico) {
		this.descricao = descricao;
		this.titulo = titulo;
		this.user = usuario;
		this.tipo_servico = tipo_servico;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsuario(User usuario) {
		this.user = usuario;
	}

	public User getUsuario() {
		return user;
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
