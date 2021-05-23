package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bd.dal.AnuncioDAL;
import com.example.demo.bd.dal.TipoServicoDAL;
import com.example.demo.bd.entidade.Anuncio;
import com.example.demo.bd.entidade.TIpoServico;

@RestController
public class AnuncioController {
	
	@RequestMapping(value="/anuncio/listar")	
	public ResponseEntity <Object> listar()
	{
		Map<String,Anuncio> mapanuncios = new HashMap<>();
		List<Anuncio> todos = new AnuncioDAL().getAnuncio("");
		for(Anuncio a : todos)
			mapanuncios.put(""+a.getId(), a);
		return new ResponseEntity<>(mapanuncios.values(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/anuncio/pesquisar")	
	public ResponseEntity <Object> pesquisar(@RequestParam(value="chave") String chave)
	{
		Map<String,Anuncio> mapanuncios = new HashMap<>();
		List<Anuncio> todos = new AnuncioDAL().getAnuncio("titulo LIKE '%"+ chave + "%'");
		for(Anuncio a : todos)
			mapanuncios.put(""+a.getId(), a);
		return new ResponseEntity<>(mapanuncios.values(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/inserir")
	public ResponseEntity<Object> inserir(@RequestBody Anuncio anuncio)
	{
		boolean result = new AnuncioDAL().salvar(anuncio);
		if(!result)
			return new ResponseEntity<>("Erro Ao Cadastrar",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("Salvo com Sucesso",HttpStatus.CREATED);
	}
}
