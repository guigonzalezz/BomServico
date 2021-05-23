package com.bomservico.bd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bomservico.model.Anuncio;
import com.bomservico.model.Usuario;


@Repository
public class AnuncioDao {

	@PersistenceContext
	private EntityManager em;

	public void salvar(Anuncio leilao) {
		em.merge(leilao);
	}

	public Anuncio buscarPorId(Long id) {
		return em.find(Anuncio.class, id);
	}

	public List<Anuncio> buscarTodos() {
		return em.createQuery("SELECT * FROM anuncio", Anuncio.class)
				.getResultList();
	}

	public List<Anuncio> buscarAnunciosPorTipoServico(Long id) {
		return em.createQuery("SELECT * FROM anuncio WHERE anuncio.tipo_servico_id = :id", Anuncio.class)
				.setParameter("id", id)
				.getResultList();
	}

	public List<Anuncio> buscarAnunciosDoUsuario(Usuario usuario) {
		return em.createQuery("SELECT * FROM anuncio WHERE anuncio.user_id = :usuario", Anuncio.class)
				.setParameter("usuario", usuario.getId())
				.getResultList();
	}

}
