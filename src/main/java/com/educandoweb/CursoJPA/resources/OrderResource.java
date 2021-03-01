package com.educandoweb.cursojpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.cursojpa.entities.Order;
import com.educandoweb.cursojpa.services.OrderService;

//Recurso Web
@RestController
//Nome para o meu Recurso
@RequestMapping(value = "/orders")
//Resource: recurso
public class OrderResource {
	
	@Autowired //faz com que a classe seja ejetada automaticamente
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> buscarTodos() {
		List<Order> lista = orderService.listarTodos();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Order> buscarPorCodigo(@PathVariable Long codigo) {
		Order objetoOrder = orderService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(objetoOrder); 
	}
}
