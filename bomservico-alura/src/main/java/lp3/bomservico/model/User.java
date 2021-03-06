package lp3.bomservico.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	private String username;
	private String password;
	private Boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user", fetch= FetchType.LAZY)
	private List<Anuncio> anuncios;
	
    private String role;
	
	public User() {
		
	}
		
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public User(String username, String password, Boolean enabled, String role) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String login) {
		this.username = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String senha) {
		this.password = senha;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
