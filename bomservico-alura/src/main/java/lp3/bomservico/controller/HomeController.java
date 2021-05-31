package lp3.bomservico.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lp3.bomservico.model.Anuncio;
import lp3.bomservico.model.TipoServico;
import lp3.bomservico.service.AnuncioService;
import lp3.bomservico.service.TipoServicoService;

@Controller
@RequestMapping("/home")
public class HomeController {

	
	@Autowired
	private AnuncioService anuncioService;
	@Autowired
	private TipoServicoService tipoServicoService;
	
	
	@GetMapping
	public ModelAndView home(Principal principal) {
		ModelAndView mv = new ModelAndView("home");
		
		Iterable<Anuncio> anuncios = anuncioService.listar();
		Iterable<TipoServico> tipos_servicos = tipoServicoService.listar();
		
		mv.addObject("tipos_servicos", tipos_servicos);
		mv.addObject("anuncios", anuncios);
		return mv;
	}
	
	@GetMapping("/{tipo_servico}")
	public ModelAndView listaAnuncioTipoServico(@PathVariable("tipo_servico")int tipo_servico_id) {
		ModelAndView mv = new ModelAndView("home");
		boolean verificaArg = false;
		String tipo_servico = "";
		
		Iterable<TipoServico> tipos_servicos = tipoServicoService.listar();
		
		
		for(TipoServico tipo : tipos_servicos) {
			if(tipo.getId() == (long)tipo_servico_id) {
				tipo_servico = tipo.getNome();
				verificaArg = true;
			}
		}
		
		Iterable<Anuncio> anuncios = anuncioService.buscaAnuncioPorTipoServico(tipo_servico);
		
		if(!verificaArg ){
			mv = new ModelAndView("redirect:/home");
		}
		
		mv.addObject("tipos_servicos", tipos_servicos);
		mv.addObject("anuncios", anuncios);
		return mv;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}

	
	
}
