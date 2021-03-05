package com.educandoweb.cursojpa.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object codigo) {
		super("Registro não encontrado. Código: " + codigo);
	}
}
