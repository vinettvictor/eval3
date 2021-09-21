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

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
		
	@RequestMapping("")
	public String index(@ModelAttribute("producto") Producto producto, Model model) {
	
		List<Producto> lista_productos = productoService.findAll();
		model.addAttribute("lista_productos", lista_productos);
		return "producto.jsp";
	}
	
		//METODO PARA INSERTAR DATOS
		@RequestMapping(value="/crear", method = RequestMethod.POST)
		public String crearProducto(@Valid @ModelAttribute("producto") Producto producto) {				
			
				if(!producto.getNombre().isBlank() 
						&& !producto.getPrecio().equals(null)
						&& !producto.getDescripcion().isBlank()){					
						productoService.crearProducto(producto); 
						System.out.println("Producto creado corretamente:  " +producto.getNombre() + " ");					
				}else {
					
					System.out.println("Por favor los campos no pueden estar vacio");
				}			
			return "redirect:/producto"; //redirect: enviamos a la ruta que queremos mostrar
		}
		
		//METODO PARA ACTUALIZAR
		@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
		public String actualizarProducto(@PathVariable("id") Long id, Model model) {
			System.out.println("El id a actualizar es: "+id);
			Producto producto = productoService.buscarProducto(id);
			model.addAttribute("producto", producto);
			return "editarProducto.jsp";
		}
		
		
		//MÉTODO CREADO PARA MODIFICAR
		@RequestMapping(value = "/modificar", method = RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("producto") Producto producto) {
			System.out.println("id a modificar: " + producto.getId());
			
			//Validamos que no sea nulo los datos
			if(!producto.getNombre().isBlank() 
					&& !producto.getPrecio().equals(null)
					&& !producto.getDescripcion().isBlank()){			
					productoService.crearProducto(producto); 
					System.out.println("Producto creado corretamente:  " +producto.getNombre() + " ");					
					return "redirect:/producto"; //Si cumple la validaciones el usuario de actualiza y redirecciona a la ruta /producto
			}else {
				
				System.out.println("Por favor los campos no pueden estar vacio");
			}					
			return "redirect:/producto/actualizar/"+producto.getId(); //si no cumple las validaciones, se queda en la misma ruta de modificar usuario
		}
		
		
		//METODO PARA ELIMINAR
		@RequestMapping(value="/eliminar/{id}", method = RequestMethod.GET)
		public String eliminarProducto(@PathVariable("id") Long id) {
			System.out.println("El id a eliminar es: "+id);
			productoService.eliminarProducto(id);
			return "redirect:/producto";
		}
	
	
}
