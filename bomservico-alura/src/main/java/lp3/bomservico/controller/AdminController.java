package lp3.bomservico.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lp3.bomservico.dto.RequisicaoNovoTipoServico;
import lp3.bomservico.model.Anuncio;
import lp3.bomservico.model.TipoServico;
import lp3.bomservico.service.AnuncioService;
import lp3.bomservico.service.TipoServicoService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private TipoServicoService tipoServicoService;
	
	@Autowired
	private AnuncioService anuncioService;

	@GetMapping("painel")
	public ModelAndView painel(RequisicaoNovoTipoServico requisicaoNovoTipoServico) {
		Iterable<TipoServico> tipos_servicos = tipoServicoService.listar();
		Iterable<Anuncio> anuncios = anuncioService.listar();
		ModelAndView mv = new ModelAndView("admin/painel");
		mv.addObject("tipos_servicos", tipos_servicos);
		mv.addObject("anuncios", anuncios);
		
		
		return mv;
	}
	
	@PostMapping("novo")
	@Transactional
	public ModelAndView novo(@Valid RequisicaoNovoTipoServico requisicaoNovoTipoServico,  BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:painel");
		
		if (result.hasErrors()) {
			return mv;
		}
		
		tipoServicoService.salvar(requisicaoNovoTipoServico.getNome());
		return mv;
	}
	
	@DeleteMapping("tipoServico/deletar/{id}")
	@Transactional
	public String deletarTipoServico(@PathVariable String id) {
		String msg = "Deletado com sucesso!";
		//ModelAndView mv = new ModelAndView("admin/painel");
		List<Anuncio> anuncios = anuncioService.buscaAnuncioPorTipoServicoId(Long.parseLong(id));
		if(anuncios == null || anuncios.isEmpty())
		{
			tipoServicoService.deletar(Long.parseLong(id));
			//mv.addObject("msg", msg);
		}
		else {
			msg = "Não é possível deletar, tipo servico vinculado a um anuncio!";
			//mv.addObject("msg","Não é possível deletar, tipo servico vinculado a um anuncio!");
		}
			
		return msg;
	}
	
	@DeleteMapping("anuncio/deletar/{id}")
	@Transactional
	public String deletarAnuncio(@PathVariable String id) {
		String msg = "Deletado com sucesso!";
		anuncioService.deletar(Long.parseLong(id));	
		return msg;
	}
	
}
