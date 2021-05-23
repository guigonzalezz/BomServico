package com.bomservico.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bomservico.bd.dao.UsuarioDao;
import com.bomservico.model.Usuario;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioDao.buscarPorUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}

		return new AnuncioUserDetails(user);
	}

}
