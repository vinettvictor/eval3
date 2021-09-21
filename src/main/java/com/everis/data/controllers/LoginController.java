package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password,
			HttpSession session) {
		
		System.out.println("llegamos hasta ingresar!");
		boolean existeUsuario = usuarioService.validarUsuario(email, password);
		if(existeUsuario) {
			Usuario usuario = usuarioService.findByEmail(email);
			//guardando un elemento en session
			session.setAttribute("usuarioId", usuario.getId());
			return "home.jsp";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session){
		//valida el acceso a rutas
		if(session.getAttribute("usuarioId")!=null) {
			return "home.jsp";
		}
		return "redirect:/login";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		if(session.getAttribute("usuarioId")!=null) {
			session.invalidate();//matamos todas las variables de session
		}
		return "redirect:/";
	}
}
