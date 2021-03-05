package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.Usuario;
import com.educandoweb.cursojpa.repositories.RepositorioUsuario;
import com.educandoweb.cursojpa.services.exceptions.ResourceNotFoundException;

@Service
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	public List<Usuario> listarTodos() {
		return repositorioUsuario.findAll();
	}

	// findById: buscarPorCodigo
	public Usuario buscarPorCodigo(Long codigo) {
		Optional<Usuario> objetoUsuario = repositorioUsuario.findById(codigo);
		return objetoUsuario.orElseThrow(() -> new ResourceNotFoundException(codigo));
	}

	// realizar insercao no Banco de Dados - tabela tb_usuario
	public Usuario inserir(Usuario objetoUsuario) {
		return repositorioUsuario.save(objetoUsuario);
	}

	// realizar exclusão na tb_usuario passando o codigo como parâmetro
	public void excluir(Long codigo) {
		repositorioUsuario.deleteById(codigo);
	}

	// realizar alteração (edição) na tb_usuario passando o codigo como parâmetro
	public Usuario alterar(Long codigo, Usuario objetoUsuario) {
		Usuario entidadeUsuario = repositorioUsuario.getOne(codigo);
		atualizarDadosUsuario(entidadeUsuario, objetoUsuario);
		return repositorioUsuario.save(entidadeUsuario);
	}

	private void atualizarDadosUsuario(Usuario entidadeUsuario, Usuario objetoUsuario) {
		entidadeUsuario.setNomeUsuario(objetoUsuario.getNomeUsuario());
		entidadeUsuario.setEmailUsuario(objetoUsuario.getEmailUsuario());
		entidadeUsuario.setTelefoneUsuario(objetoUsuario.getTelefoneUsuario());
	}

}
