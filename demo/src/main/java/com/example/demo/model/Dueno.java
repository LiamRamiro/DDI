package com.example.demo.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Dueno {
	private Integer id;
	private String nombre;

	private String dni;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
