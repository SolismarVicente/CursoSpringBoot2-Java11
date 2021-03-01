package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.Order;
import com.educandoweb.cursojpa.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> listarTodos() {
		return orderRepository.findAll();
	}
	
	//findById: buscarPorCodigo
	public Order buscarPorCodigo(Long codigo) {
		Optional<Order> objetoOrder = orderRepository.findById(codigo);
		return objetoOrder.get();
	}
	
}
