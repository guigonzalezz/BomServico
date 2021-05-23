package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bd.Singleton;
import com.example.demo.entity.Pessoa;


@RestController
public class MeusAmigosServiceController 
{
	@RequestMapping(value="/listar")	
	public ResponseEntity <Object> listarTodos()
	{
		Map<String,Pessoa> mappessoas = new HashMap<>();
		List<Pessoa> todos = Singleton.equipe;
		for(Pessoa p : todos)
		   mappessoas.put(""+p.getId(), p);
		return new ResponseEntity<>(mappessoas.values(),HttpStatus.OK);		
	}
	
	@RequestMapping(value="/buscar")	
	public ResponseEntity <Object> buscar(@RequestParam(value="id") int id)
	{   Pessoa p=null;

	    for (Pessoa pe : Singleton.equipe)
	         if (pe.getId()==id) p=pe;

	    return new ResponseEntity<>(p,HttpStatus.OK);
	}

	@RequestMapping(value="/apagar")	
	public ResponseEntity <Object> apagar(@RequestParam(value="id") int id)
	{
		String retorno="problemas ao apagar";
		for (Pessoa pe : Singleton.equipe)
		  if (pe.getId()==id){ 
	         Singleton.equipe.remove(pe); 
	         retorno="Excluído com sucesso";
	         break;}
		return new ResponseEntity<>(retorno,HttpStatus.OK); 	
	}

	@RequestMapping(value="/listarFiltro")	
	public ResponseEntity <Object> listarFiltro(@RequestParam(value="chave") String  
	                              chave, @RequestParam(required=false) String filtro)
	{
	  Map<String,Pessoa> mappessoas = new HashMap<>();
	  if(chave.equals("MINHACHAVEVALIDA"))
	  {
	     List<Pessoa> todos = Singleton.equipe;
	     for(Pessoa p : todos)
	     if(filtro==null || p.getNome().toUpperCase().contains(filtro.toUpperCase()))
	          mappessoas.put(""+p.getId(), p);
	  }
	  return new ResponseEntity<>(mappessoas.values(),HttpStatus.OK);		
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Object> cadPessoa(@RequestBody Pessoa pessoa) 
	{ String retorno="Gravado com sucesso";
	  if (pessoa.getId()==0) 
	  {  pessoa.setId(Singleton.nextID++);
	     Singleton.equipe.add(pessoa);
	  }
	  else  //alteração
	  {  int i=0;
	     retorno="Alterado com sucesso";
	     while(Singleton.equipe.get(i).getId()!=pessoa.getId()) i++;
	     if(i<Singleton.equipe.size()) Singleton.equipe.set(i, pessoa);
	     else retorno="Erro ao alterar";
	  }
	  return new ResponseEntity<>(retorno,HttpStatus.CREATED);
	}




}
