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
	@Autowired
	private AnuncioService anuncioService;
	@Autowired
	private TipoServicoService tipoServicoService;
	@Autowired
	private UserService usuarioService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BomservicoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*IDEIA DE COMO INSERIR UM REGISTRO
		TipoServico tiposervico = tipoServicoService.salvar("Informatica");
		Usuario usuario = usuarioService.salvar("Guilherme", "gui", "123", true, "USER");
		anuncioService.salvar("", "", tiposervico, usuario);
		*/
		
		/*IDEIA DE COMO ALTERAR UM REGISTRO
		TipoServico tiposervico = tipoServicoService.buscarPorId(6l);
		anuncioService.atualizar(6l,"Plantação de capim verde", "descricao teste", tiposervico);
		*/
		
		/*IDEIA DE COMO LISTAR 
		anuncioService.listar();
		*/
		/*IDEIA DE COMO DELETAR UM REGISTRO
		anuncioService.deletar(6l);
		*/
		
		//BUSCA DE UM TITULO EM ESPECIFICO 
		//anuncioService.buscaAnuncioTitulo("Manutenção de Veículos");
		
		//BUSCA FILTRADA PROCURANDO ONDE CONTEM A STRING NO TITULO
		//anuncioService.buscaAnuncioLikeTitulo("Manutenção");
		
		//BUSCA POR TIPO DE SERVICO ESPECIFICO NO ANUNCIO
		//anuncioService.buscaAnuncioPorTipoServico("Manutenção");
		
		
		/*IDEIA DE COMO LISTAR PAGINADO
		anuncioService.listarPaginado(0);
		*/
		
		/*VALIDA O ACESSO PARA O LOGIN
		System.out.println(usuarioService.validarAcesso("gui", "123", true));
		*/
	}

}
