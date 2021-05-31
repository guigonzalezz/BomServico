package lp3.bomservico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp3.bomservico.model.Anuncio;
import lp3.bomservico.model.TipoServico;
import lp3.bomservico.model.User;
import lp3.bomservico.repository.AnuncioRepository;
import lp3.bomservico.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User salvar(String username, String password) {
		User usuario = new User(username,password);
		return userRepository.save(usuario);
	}
	
	public boolean validarAcesso(String username, String password, boolean enabled) {
		return userRepository.existsByUsernameAndPasswordAndEnabled(username, password, enabled);
	}
	
	public User buscarPorUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	public void atualizar(long id, boolean enabled) {//SERVE PRA ATIVAR OU DESATIVAR USUARIO
		User usuario = userRepository.findById(id).get();
		usuario.setEnabled(enabled);
		userRepository.save(usuario);
	}
	
	public Iterable<User> listar() {
		return userRepository.findAll();
	}
	
	public void deletar(long id) {
		userRepository.deleteById(id);
	}
}
