package com.bomservico.controller;

import java.security.Principal;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bomservico.bd.dao.AnuncioDao;
import com.bomservico.bd.dao.UsuarioDao;
import com.bomservico.bd.dto.NovoAnuncioDto;
import com.bomservico.model.Anuncio;
import com.bomservico.model.Usuario;


@Controller
@RequestMapping("/anuncios")
public class AnuncioController {

	@Autowired
	private AnuncioDao anuncios;

	@Autowired
	private UsuarioDao usuarios;

	@GetMapping
	public ModelAndView index(Principal principal) {
		ModelAndView mv = new ModelAndView("anuncio/index");
		mv.addObject("anuncios", anuncios.buscarTodos());
		mv.addObject("usuarioLogado", principal);
		return mv;
	}

	@GetMapping("/{id}/form")
	public ModelAndView form(@PathVariable("id") Long id, Principal principal) {
		Anuncio anuncio = anuncios.buscarPorId(id);
		NovoAnuncioDto form = new NovoAnuncioDto(anuncio);

		ModelAndView mv = new ModelAndView("anuncio/form");
		mv.addObject("usuario", principal.getName());
		mv.addObject("anuncio", form);
		return mv;
	}

	@PostMapping
	@Transactional
	public ModelAndView saveOrUpdate(@Valid @ModelAttribute("anuncio") NovoAnuncioDto anuncioForm, Errors errors, RedirectAttributes attr, Principal principal) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("/anuncio/form");
			mv.addObject("anuncio", anuncioForm);
			mv.addObject("usuario", principal.getName());
			return mv;
		}

		Usuario usuario = usuarios.buscarPorUsername(principal.getName());
		Anuncio anuncio = anuncioForm.toAnuncio();
		anuncio.setUsuario(usuario);

		anuncios.salvar(anuncio);

		attr.addFlashAttribute("message", "Anuncio salvo com sucesso");

		return new ModelAndView("redirect:/anuncios");
	}

	@GetMapping("/new")
	public ModelAndView newLeilao(Principal principal) {
		ModelAndView mv = new ModelAndView("anuncio/form");
		mv.addObject("usuario", principal.getName());
		mv.addObject("anuncio", new NovoAnuncioDto());
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Long id, Principal principal) {
		ModelAndView mv = new ModelAndView("anuncio/show");
		mv.addObject("usuario", principal.getName());
		mv.addObject("anuncio", anuncios.buscarPorId(id));
		return mv;
	}

}