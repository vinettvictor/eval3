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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Integer precio;
	private String descripcion;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="productos_usuarios",
	joinColumns = @JoinColumn(name="producto_id"), //nombre asociado a la entidad
	inverseJoinColumns = @JoinColumn(name="usuario_id")) //nombre a tabla relacional
	private List<Usuario> usuarios;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	public Producto() {
		super();
	}
	
	
	public Producto(String nombre, Integer precio, String descripcion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
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



	public Integer getPrecio() {
		return precio;
	}



	public void setPrecio(Integer precio) {
		this.precio = precio;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
}
