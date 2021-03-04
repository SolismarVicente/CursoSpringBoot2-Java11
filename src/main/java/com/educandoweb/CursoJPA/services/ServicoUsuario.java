package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.Usuario;
import com.educandoweb.cursojpa.repositories.RepositorioUsuario;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public List<Usuario> listarTodos() {
		return repositorioUsuario.findAll();
	}
	
	//findById: buscarPorCodigo
	public Usuario buscarPorCodigo(Long codigo) {
		Optional<Usuario> objetoUsuario = repositorioUsuario.findById(codigo);
		return objetoUsuario.get();
	}
	
	//realizar insercao no Banco de Dados - tabela tb_usuario
	public Usuario inserir(Usuario objetoUsuario) {
		return repositorioUsuario.save(objetoUsuario);
	}
	
}
