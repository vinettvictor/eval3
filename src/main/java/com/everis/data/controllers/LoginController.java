package com.everis.data.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.models.Usuario;
import com.everis.data.services.ProductoService;
import com.everis.data.services.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProductoService productoService;

	@RequestMapping("/")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password,
			HttpSession session) {
		
		boolean existeUsuario = usuarioService.validarUsuario(email, password);
		if(existeUsuario) {
			Usuario usuario = usuarioService.findByEmail(email);
			//guardando un elemento en session
			session.setAttribute("usuarioId", usuario.getId());
			return "redirect:/home";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(HttpSession session,@ModelAttribute("producto") Producto producto,@ModelAttribute("usuario") Usuario usuario, Model model){
		//valida el acceso a rutas
		if(session.getAttribute("usuarioId")!=null) {
			List<Usuario> lista_usuarios = usuarioService.findAll();
			model.addAttribute("lista_usuarios", lista_usuarios);
			model.addAttribute("lista_productos", productoService.findAll());
			
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
