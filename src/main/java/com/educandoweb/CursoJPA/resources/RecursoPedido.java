package com.educandoweb.cursojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.Pedido;
import com.educandoweb.cursojpa.services.ServicoPedido;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/pedidos")
//Resource: recurso
public class RecursoPedido {
	
	@Autowired //faz com que a classe seja ejetada automaticamente
	private ServicoPedido servicoPedido;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos() {
		List<Pedido> lista = servicoPedido.listarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Pedido> buscarPorCodigo(@PathVariable Long codigo) {
		Pedido objetoPedido = servicoPedido.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(objetoPedido); 
	}
}
