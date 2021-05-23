package com.bomservico.bd.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bomservico.model.Usuario;


@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario buscarPorUsername(String username) {
		return em.createQuery("SELECT * FROM user WHERE user.login = :username", Usuario.class)
				.setParameter("username", username)
				.getSingleResult();
	}

	public void deletar(Usuario usuario) {
		em.remove(usuario);
	}

}
