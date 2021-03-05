package com.educandoweb.cursojpa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Usuario> inserirRegistro(@RequestBody Usuario objetoUsuario) {
		objetoUsuario = servicoUsuario.inserir(objetoUsuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}").
				buildAndExpand(objetoUsuario.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(objetoUsuario); 
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluirRegistro(@PathVariable Long codigo) {
		servicoUsuario.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Usuario> alterarRegistro(@PathVariable Long codigo, @RequestBody Usuario objetoUsuario) {
		objetoUsuario = servicoUsuario.alterar(codigo, objetoUsuario);
		return ResponseEntity.ok().body(objetoUsuario);
	}
}
