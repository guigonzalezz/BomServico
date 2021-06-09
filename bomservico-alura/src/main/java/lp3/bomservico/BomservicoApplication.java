package lp3.bomservico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lp3.bomservico.service.AnuncioService;
import lp3.bomservico.service.TipoServicoService;
import lp3.bomservico.service.UserService;

@SpringBootApplication
public class BomservicoApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(BomservicoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

	}

}
