package lp3.bomservico.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lp3.bomservico.dto.RequisicaoNovoAnuncio;
import lp3.bomservico.model.Anuncio;
import lp3.bomservico.model.TipoServico;
import lp3.bomservico.model.User;
import lp3.bomservico.service.AnuncioService;
import lp3.bomservico.service.TipoServicoService;
import lp3.bomservico.service.UserService;

@Controller
@RequestMapping("anuncio")
public class AnuncioController {

	@Autowired
	private AnuncioService anuncioService;

	@Autowired
	private TipoServicoService tipoServicoService;

	@Autowired
	private UserService userService;

	/*
	 * @GetMapping("/home") public String home(Model model) { Iterable<Anuncio>
	 * anuncios = anuncioService.listar(); model.addAttribute("anuncios", anuncios);
	 * return "home"; }
	 */
	// DE AMBAS AS FORMAS FUNCIONAM
//	@GetMapping("meusanuncios")
//	public ModelAndView home() {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		Iterable<Anuncio> anuncios = anuncioService.findAllByUsuario(username);
//		ModelAndView mv = new ModelAndView("anuncio/meusanuncios");
//		mv.addObject("anuncios", anuncios);
//		return mv;
//	}

	// @RequestMapping(method = RequestMethod.GET, value="formulario")
	@GetMapping("formulario")
	public ModelAndView formulario(RequisicaoNovoAnuncio requisicaoNovoAnuncio) {
		Iterable<TipoServico> tipos_servicos = tipoServicoService.listar();
		ModelAndView mv = new ModelAndView("anuncio/formulario");
		mv.addObject("tipos_servicos", tipos_servicos);
		return mv;
	}

	// @RequestMapping(method = RequestMethod.POST, value="novo")
	@PostMapping("novo")
	public ModelAndView novo(@Valid RequisicaoNovoAnuncio requisicaoNovoAnuncio, BindingResult result) {
		Iterable<TipoServico> tipos_servicos = tipoServicoService.listar();
		ModelAndView mv = new ModelAndView("anuncio/formulario");
		mv.addObject("tipos_servicos", tipos_servicos);
		if (result.hasErrors()) {
			return mv;
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User usuario = userService.buscarPorUsername(username);

		anuncioService.salvar(requisicaoNovoAnuncio.getTitulo(), requisicaoNovoAnuncio.getDescricao(),
				tipoServicoService.buscarPorId((long) requisicaoNovoAnuncio.getTipo_servico()),
				usuario);
		return mv;// APOS INSERIR REDIRECIONA PARA

	}


}
