package com.educandoweb.cursojpa.services.exceptions;

public class ExcecaoRegistroNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExcecaoRegistroNaoEncontrado(Object codigo) {
		super("Registro não encontrado. Código: " + codigo);
	}
}
