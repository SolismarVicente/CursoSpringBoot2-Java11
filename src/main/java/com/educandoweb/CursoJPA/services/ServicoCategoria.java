package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.Categoria;
import com.educandoweb.cursojpa.repositories.RepositorioCategoria;

@Service
public class ServicoCategoria {

	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	public List<Categoria> listarTodos() {
		return repositorioCategoria.findAll();
	}
	
	//findById: buscarPorCodigo
	public Categoria buscarPorCodigo(Long codigo) {
		Optional<Categoria> objetoCategoria = repositorioCategoria.findById(codigo);
		return objetoCategoria.get();
	}
	
}
