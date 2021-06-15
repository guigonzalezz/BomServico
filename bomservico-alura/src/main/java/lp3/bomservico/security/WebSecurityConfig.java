package lp3.bomservico.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Qualifier("userDetailsServiceImpl")
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/home/**").permitAll()
				.antMatchers("/cadastro/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl("/usuario/anuncio", true)
					.permitAll()
			)
			.logout(logout -> {
				logout.logoutUrl("/logout")
					.logoutSuccessUrl("/home");
			})
			.csrf().disable();
		
	}
	
	
	
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(encoder);
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.passwordEncoder(encoder);
	}

	
}
