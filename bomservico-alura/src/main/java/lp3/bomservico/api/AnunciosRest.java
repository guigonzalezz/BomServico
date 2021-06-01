package lp3.bomservico.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lp3.bomservico.dto.RequisicaoNovoAnuncio;
import lp3.bomservico.model.Anuncio;
import lp3.bomservico.model.TipoServico;
import lp3.bomservico.model.User;
import lp3.bomservico.service.AnuncioService;
import lp3.bomservico.service.TipoServicoService;
import lp3.bomservico.service.UserService;

@RestController
@RequestMapping("/api/anuncios")
public class AnunciosRest {
	
	@Autowired
	private AnuncioService anuncioService;
	@Autowired
	private TipoServicoService tipoServicoService;
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Anuncio> getAnunciosAguardandoOfertas(){
		return  (List<Anuncio>) anuncioService.listar();
	}
	
	@PostMapping("novo")
	public Anuncio novo(@RequestBody RequisicaoNovoAnuncio requisicaoNovoAnuncio) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User usuario = userService.buscarPorUsername(username);
		TipoServico tipo_servico = tipoServicoService.buscarPorId((long) requisicaoNovoAnuncio.getTipo_servico());

		return anuncioService.salvar(requisicaoNovoAnuncio.getTitulo(), requisicaoNovoAnuncio.getDescricao(),
				tipo_servico,
				usuario);
	}
	
	
	
	
}
