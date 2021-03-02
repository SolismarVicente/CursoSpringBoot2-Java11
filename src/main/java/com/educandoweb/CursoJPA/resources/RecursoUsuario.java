package com.educandoweb.cursojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.Usuario;
import com.educandoweb.cursojpa.services.ServicoUsuario;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/usuarios")
//Resource: recurso
public class RecursoUsuario {
	
	@Autowired //faz com que a classe seja ejetada automaticamente
	private ServicoUsuario servicoUsuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos() {
		List<Usuario> lista = servicoUsuario.listarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Usuario> buscarPorCodigo(@PathVariable Long codigo) {
		Usuario objetoUsuario = servicoUsuario.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(objetoUsuario); 
	}
}
