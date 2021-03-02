package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.Pedido;
import com.educandoweb.cursojpa.repositories.RepositorioPedido;

@Service
public class ServicoPedido {

	@Autowired
	private RepositorioPedido repositorioPedido;
	
	public List<Pedido> listarTodos() {
		return repositorioPedido.findAll();
	}
	
	//findById: buscarPorCodigo
	public Pedido buscarPorCodigo(Long codigo) {
		Optional<Pedido> objetoPedido = repositorioPedido.findById(codigo);
		return objetoPedido.get();
	}
	
}
