package com.educandoweb.cursojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.Categoria;
import com.educandoweb.cursojpa.services.ServicoCategoria;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/categorias")
//Resource: recurso
public class RecursoCategoria {
	
	@Autowired //faz com que a classe seja ejetada automaticamente
	private ServicoCategoria servicoCategoria;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		List<Categoria> lista = servicoCategoria.listarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Categoria> buscarPorCodigo(@PathVariable Long codigo) {
		Categoria objetoCategoria = servicoCategoria.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(objetoCategoria); 
	}
}
