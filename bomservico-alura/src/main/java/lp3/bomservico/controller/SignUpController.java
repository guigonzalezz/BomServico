package lp3.bomservico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lp3.bomservico.dto.RequisicaoNovoUsuario;
import lp3.bomservico.model.User;
import lp3.bomservico.security.SecurityServiceImpl;
import lp3.bomservico.service.UserService;

@Controller
@RequestMapping("/cadastro")
public class SignUpController {


	@Autowired
	private UserService userService;
	 @Autowired
	 private SecurityServiceImpl securityService;

	@GetMapping
	public ModelAndView formulario(RequisicaoNovoUsuario requisicaoNovoUsuario) {
		ModelAndView mv = new ModelAndView("cadastro");
		return mv;
	}

	@PostMapping("novo")
	public ModelAndView novo(@Valid RequisicaoNovoUsuario requisicaoNovoUsuario, BindingResult result) {
		
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("msg", "");
		if (result.hasErrors()) {
			return mv;
		}
		
		User usuario = userService.buscarPorUsername(requisicaoNovoUsuario.getUsername());
		if(usuario != null) {
			mv.addObject("msg", "Usuário com este username já existe!");
			System.out.println("Usuário com este username já existe!");
			return mv;						
		}
		userService.salvar(requisicaoNovoUsuario.getUsername(), requisicaoNovoUsuario.getPassword());
		securityService.autoLogin(requisicaoNovoUsuario.getUsername(), requisicaoNovoUsuario.getPassword());
		mv.addObject("msg", "Cadastro concluido!");
		return new ModelAndView("redirect:/home");
		
	}


}
