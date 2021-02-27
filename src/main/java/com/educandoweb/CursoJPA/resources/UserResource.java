package com.educandoweb.cursojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.User;
import com.educandoweb.cursojpa.services.UserService;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/users")
//Resource: recurso
public class UserResource {
	
	@Autowired //faz com que a classe seja ejetada automaticamente
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> buscarTodos() {
		List<User> lista = userService.listarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<User> buscarPorCodigo(@PathVariable Long codigo) {
		User objetoUser = userService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(objetoUser); 
	}
}
