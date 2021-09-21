package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public void crearProducto(@Valid Producto producto) {			
		productoRepository.save(producto);
	}
	
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}
	
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);		
	}
	
	public Producto buscarProducto(Long id) {
		Optional<Producto> oProducto = productoRepository.findById(id);
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}
	
	public void modificarProducto(@Valid Producto producto) {	
		productoRepository.save(producto);
	}
}
