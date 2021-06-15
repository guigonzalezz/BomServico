package lp3.bomservico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lp3.bomservico.model.User;
import lp3.bomservico.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public User salvar(String username, String password) {
		User usuario = new User();
		usuario.setUsername(username);
		usuario.setPassword(bCryptPasswordEncoder.encode(password));
		usuario.setEnabled(true);
        usuario.setRole("ROLE_USER");
        userRepository.save(usuario);
		return usuario;
	}
	
	public boolean validarAcesso(String username, String password, boolean enabled) {
		return userRepository.existsByUsernameAndPasswordAndEnabled(username, password, enabled);
	}
	
	public User buscarPorUsername(String username){
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
