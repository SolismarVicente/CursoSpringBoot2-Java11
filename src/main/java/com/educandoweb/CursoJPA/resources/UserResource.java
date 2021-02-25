package com.educandoweb.cursojpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.User;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> buscarTodos() {
		System.out.println("ResponseEntity");
		User usuario = new User(1L, "Maria", "maria@gmail.com", "99999-9999", "123456");
		
		return ResponseEntity.ok().body(usuario);
	}
}
