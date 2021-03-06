package com.educandoweb.cursojpa.services.exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//Erro de Integridade Referencial
	public DatabaseException(Object codigo) {
		super("Erro de Integridade Referencial ao excluir o código: " + codigo);
		//super(msg);
	}
	
	
}
