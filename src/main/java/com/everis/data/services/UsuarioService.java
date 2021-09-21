package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void crearUsuario(@Valid Usuario usuario) {	
		String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(hashed);
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);		
	}
	
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> oUsuario = usuarioRepository.findById(id);
		if(oUsuario.isPresent()) {
			return oUsuario.get();
		}
		return null;
	}
	
	public void modificarPersona(@Valid Usuario usuario) {	
		usuarioRepository.save(usuario);
	}	
	
	public boolean validarUsuario(String email, String password) {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		//siempre validar si es null
		if(usuario.equals(null)) {
			return false;
		}else {
			//comparar los password
			if (BCrypt.checkpw(password, usuario.getPassword())) {
			    System.out.println("Password iguales");
				return true;
				
			}else {
			    System.out.println("Password Distintos");
			    return false;
			}
			
		}
	}

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
}
