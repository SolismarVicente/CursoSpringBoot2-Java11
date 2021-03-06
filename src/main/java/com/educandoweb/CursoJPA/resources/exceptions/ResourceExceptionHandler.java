package com.educandoweb.cursojpa.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.cursojpa.services.exceptions.ExcecaoIntegridadeReferencial;
import com.educandoweb.cursojpa.services.exceptions.ExcecaoRegistroNaoEncontrado;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ExcecaoRegistroNaoEncontrado.class)
	public ResponseEntity<StandardError> registroNaoEncontrado(ExcecaoRegistroNaoEncontrado e, HttpServletRequest request) {
		String error = "Registro não encontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ExcecaoIntegridadeReferencial.class)
	public ResponseEntity<StandardError> integridadeReferencial(ExcecaoIntegridadeReferencial e, HttpServletRequest request) {
		String error = "Erro de Banco de Dados (Integridade Referencial).";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
