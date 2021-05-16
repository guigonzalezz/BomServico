package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bd.dal.AnuncioDAL;
import com.example.demo.bd.entidade.Anuncio;

@RestController
public class HomeController {

	@RequestMapping(value="/listar")	
	public ResponseEntity <Object> listarTodos()
	{
		Map<String,Anuncio> mapanuncios = new HashMap<>();
		List<Anuncio> todos = new AnuncioDAL().getAnuncio("");
		for(Anuncio a : todos)
			mapanuncios.put(""+a.getId(), a);
		return new ResponseEntity<>(mapanuncios.values(),HttpStatus.OK);		
	}
	
}
