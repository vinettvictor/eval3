package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.everis.data.models.Usuario;
import com.everis.data.services.ProductoService;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private  UsuarioService usuarioService;
	
	@Autowired
	private ProductoService productoService;
	
		
	@RequestMapping("")
	public String index(@ModelAttribute("usuario") Usuario usuario, Model model) {
	
		List<Usuario> lista_usuarios = usuarioService.findAll();
		model.addAttribute("lista_usuarios", lista_usuarios);
		model.addAttribute("lista_productos", productoService.findAll());
		return "usuario.jsp";
	}
	
		//METODO PARA INSERTAR DATOS
		@RequestMapping(value="/crear", method = RequestMethod.POST)
		public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario) {				
			
				if(!usuario.getNombre().isBlank() 
						&& !usuario.getApellido().isBlank() 
						&& !usuario.getRut().isBlank() 
						&& !usuario.getEmail().isBlank() 
						&& !usuario.getPassword().isBlank()) {
					if(usuario.getNombre().length() <3 || usuario.getNombre().length() > 20) {
						System.out.println("error al ingresar nombre (mínimo 3 y maximo 20)");						
					}else if (usuario.getApellido().length() < 3 || usuario.getApellido().length() >20 ){
						System.out.println("error al ingresar apellido (mínimo 3 y maximo 20)");					
					}else {
						usuarioService.crearUsuario(usuario); 
						System.out.println("Usuario creado corretamente:  " +usuario.getNombre() + " " +usuario.getApellido() + " " + " " +usuario.getPassword() );
						return "login.jsp";
					}
				}else {
					
					System.out.println("Por favor los campos no pueden estar vacio");
				}			
			return "redirect:/usuario"; //redirect: enviamos a la ruta que queremos mostrar
		}
		
		//METODO PARA ACTUALIZAR
		@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
		public String actualizarUsuario(@PathVariable("id") Long id, Model model) {
			System.out.println("El id a actualizar es: "+id);
			Usuario usuario = usuarioService.buscarUsuario(id);
			model.addAttribute("usuario", usuario);
			return "editarUsuario.jsp";
		}
		
		
		//MÉTODO CREADO PARA MODIFICAR 
		@RequestMapping(value = "/modificar", method = RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario) {
			System.out.println("id a modificar: " + usuario.getId());
			
			//Validamos que no sea nulo los datos, y cumplan los requisitos de nombre y apellido
			if(!usuario.getNombre().isBlank() 
					&& !usuario.getApellido().isBlank() 
					&& !usuario.getRut().isBlank() 
					&& !usuario.getEmail().isBlank()
					&& !usuario.getPassword().isBlank()) {
				if(usuario.getNombre().length() <3 || usuario.getNombre().length() > 20) {
					System.out.println("error al ingresar nombre (mínimo 3 y maximo 20)");
				}else if (usuario.getApellido().length() < 3 || usuario.getApellido().length() >20 ){
					System.out.println("error al ingresar apellido (mínimo 3 y maximo 20)");
				} 
				else {
					usuarioService.crearUsuario(usuario); 
					System.out.println("Usuario creado:  " +usuario.getRut() + " " +usuario.getNombre() + " " + usuario.getApellido() + " ");
					return "redirect:/usuario"; //Si cumple la validaciones el usuario de actualiza y redirecciona a la ruta /usuario
				}
			}else {
				System.out.println("Por favor ingrese valores al campo, no pueden estar vacio");
			}				
			return "redirect:/usuario/actualizar/"+usuario.getId(); //si no cumple las validaciones, se queda en la misma ruta de modificar usuario
		}
				
		//METODO PARA ELIMINAR
				@RequestMapping(value="/eliminar/{id}", method = RequestMethod.GET)
				public String eliminarUsuario(@PathVariable("id") Long id) {
					System.out.println("El id a eliminar es: "+id);
					usuarioService.eliminarUsuario(id);
					return "redirect:/usuario";
				}
}
