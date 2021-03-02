package com.educandoweb.cursojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.Produto;
import com.educandoweb.cursojpa.services.ServicoProduto;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/produtos")
//Resource: recurso
public class RecursoProduto {
	
	@Autowired //faz com que a classe seja ejetada automaticamente
	private ServicoProduto servicoProduto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> lista = servicoProduto.listarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Produto> buscarPorCodigo(@PathVariable Long codigo) {
		Produto objetoProduto = servicoProduto.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(objetoProduto); 
	}
}
