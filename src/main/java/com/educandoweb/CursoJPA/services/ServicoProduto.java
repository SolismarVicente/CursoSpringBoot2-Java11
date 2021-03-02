package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.Produto;
import com.educandoweb.cursojpa.repositories.RepositorioProduto;

@Service
public class ServicoProduto {

	@Autowired
	private RepositorioProduto repositorioProduto;
	
	public List<Produto> listarTodos() {
		return repositorioProduto.findAll();
	}
	
	//findById: buscarPorCodigo
	public Produto buscarPorCodigo(Long codigo) {
		Optional<Produto> objetoProduto = repositorioProduto.findById(codigo);
		return objetoProduto.get();
	}
	
}
