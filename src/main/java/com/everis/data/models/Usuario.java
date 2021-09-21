package com.everis.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private String rut;
	private String email;
	private String password;
	@Transient
	private String passwordConfirmation;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="productos_usuarios",
	joinColumns = @JoinColumn(name="usuario_id"), //nombre asociado a la entidad
	inverseJoinColumns = @JoinColumn(name="producto_id")) //nombre a tabla relacional
	private List<Producto> productos;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String rut, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@PrePersist
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}

	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}
}
