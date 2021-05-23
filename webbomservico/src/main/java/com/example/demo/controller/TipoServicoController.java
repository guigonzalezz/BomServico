package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bd.dal.TipoServicoDAL;
import com.example.demo.bd.entidade.TIpoServico;

public class TipoServicoController {
	
	@RequestMapping(value="/tipo-servico/listar")	
	public ResponseEntity <Object> listar()
	{
		Map<String,TIpoServico> mapanuncios = new HashMap<>();
		List<TIpoServico> todos = new TipoServicoDAL().getServico("");
		for(TIpoServico a : todos)
			mapanuncios.put(""+a.getId(), a);
		return new ResponseEntity<>(mapanuncios.values(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/tipo-servico/pesquisar")	
	public ResponseEntity <Object> pesquisar(@RequestParam(value="chave") String chave)
	{
		Map<String,TIpoServico> mapanuncios = new HashMap<>();
		List<TIpoServico> todos = new TipoServicoDAL().getServico("nome LIKE '%"+ chave + "%'");
		for(TIpoServico a : todos)
			mapanuncios.put(""+a.getId(), a);
		return new ResponseEntity<>(mapanuncios.values(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/tipo-servico/inserir")
	public ResponseEntity<Object> inserir(@RequestBody TIpoServico servico)
	{
		boolean result = new TipoServicoDAL().salvar(servico);
		if(!result)
			return new ResponseEntity<>("Erro Ao Cadastrar",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("Salvo com Sucesso",HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/tipo-servico/atualizar")
	public ResponseEntity<Object> atualizar(@RequestBody TIpoServico servico)
	{
		boolean result = new TipoServicoDAL().alterar(servico);
		if(!result)
			return new ResponseEntity<>("Erro Ao Cadastrar",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("Salvo com Sucesso",HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/tipo-servico/apagar")	
	public ResponseEntity <Object> apagar(@RequestParam(value="id") int id)
	{
		String retorno="problemas ao apagar";
		boolean result = new TipoServicoDAL().apagar(id);
		if(result) {
			retorno = "Sucesso";
		}
		return new ResponseEntity<>(retorno,HttpStatus.OK);		
	}
}
