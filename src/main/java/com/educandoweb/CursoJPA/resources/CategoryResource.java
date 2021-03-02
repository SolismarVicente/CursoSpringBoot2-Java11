package com.educandoweb.cursojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.Category;
import com.educandoweb.cursojpa.services.CategoryService;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/categories")
//Resource: recurso
public class CategoryResource {
	
	@Autowired //faz com que a classe seja ejetada automaticamente
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> buscarTodos() {
		List<Category> lista = categoryService.listarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Category> buscarPorCodigo(@PathVariable Long codigo) {
		Category objetoCategory = categoryService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(objetoCategory); 
	}
}
