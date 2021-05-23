package com.bomservico.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bomservico.bd.dao.AnuncioDao;
import com.bomservico.bd.dao.UsuarioDao;
import com.bomservico.model.Anuncio;
import com.bomservico.model.Usuario;


@RestController
public class AnuncioController {

	private AnuncioDao anuncios;
	private UsuarioDao usuarios;

	@RequestMapping(value="/anuncio/index")	
	public ResponseEntity <Object> listar()
	{
		Map<String,Anuncio> mapanuncios = new HashMap<>();
		List<Anuncio> todos = new AnuncioDao().buscarTodos();
		for(Anuncio a : todos)
			mapanuncios.put(""+a.getId(), a);
		return new ResponseEntity<>(mapanuncios.values(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/anuncio/pesquisar")	
	public ResponseEntity <Object> pesquisar(@RequestParam(value="chave") String chave)
	{
		Map<String,Anuncio> mapanuncios = new HashMap<>();
		List<Anuncio> todos = new AnuncioDao().getAnuncio("titulo LIKE '%"+ chave + "%'");
		for(Anuncio a : todos)
			mapanuncios.put(""+a.getId(), a);
		return new ResponseEntity<>(mapanuncios.values(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/inserir")
	public ResponseEntity<Object> inserir(@RequestBody Anuncio anuncio)
	{
		boolean result = new AnuncioDao().salvar(anuncio);
		if(!result)
			return new ResponseEntity<>("Erro Ao Cadastrar",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("Salvo com Sucesso",HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/anuncio/{id}/form")	
	public ModelAndView form(@PathVariable("id") Long id)
	{
		Anuncio anuncio = anuncios.buscarPorId(id);
		
		ModelAndView mv = new ModelAndView("anuncio/form");	
		mv.addObject("anuncio", anuncio);
		return mv;
	}
	
//	@GetMapping("/{id}/form")
//	public ModelAndView form(@PathVariable("id") Long id, Principal principal) {
//		Anuncio anuncio = anuncios.buscarPorId(id);
//		NovoAnuncioDto form = new NovoAnuncioDto(anuncio);
//
//		ModelAndView mv = new ModelAndView("anuncio/form");
//		mv.addObject("usuario", principal.getName());
//		mv.addObject("anuncio", form);
//		return mv;
//	}

//	@PostMapping
//	@Transactional
//	public ModelAndView saveOrUpdate(@Valid @ModelAttribute("anuncio") NovoAnuncioDto anuncioForm, Errors errors, RedirectAttributes attr, Principal principal) {
//		if (errors.hasErrors()) {
//			ModelAndView mv = new ModelAndView("/anuncio/form");
//			mv.addObject("anuncio", anuncioForm);
//			mv.addObject("usuario", principal.getName());
//			return mv;
//		}
//
//		Usuario usuario = usuarios.buscarPorUsername(principal.getName());
//		Anuncio anuncio = anuncioForm.toAnuncio();
//		anuncio.setUsuario(usuario);
//
//		anuncios.salvar(anuncio);
//
//		attr.addFlashAttribute("message", "Anuncio salvo com sucesso");
//
//		return new ModelAndView("redirect:/anuncios");
//	}
//
//	@GetMapping("/new")
//	public ModelAndView newLeilao(Principal principal) {
//		ModelAndView mv = new ModelAndView("anuncio/form");
//		mv.addObject("usuario", principal.getName());
//		mv.addObject("anuncio", new NovoAnuncioDto());
//		return mv;
//	}
//
//	@GetMapping("/{id}")
//	public ModelAndView show(@PathVariable Long id, Principal principal) {
//		ModelAndView mv = new ModelAndView("anuncio/show");
//		mv.addObject("usuario", principal.getName());
//		mv.addObject("anuncio", anuncios.buscarPorId(id));
//		return mv;
//	}

}