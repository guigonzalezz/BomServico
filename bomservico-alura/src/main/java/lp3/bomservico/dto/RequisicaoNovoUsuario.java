package lp3.bomservico.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class RequisicaoNovoUsuario {
	
	@NotNull
	@NotEmpty
	private String username;
	@NotNull
	@NotEmpty
	private String password;
	
	private Boolean enabled = true;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
