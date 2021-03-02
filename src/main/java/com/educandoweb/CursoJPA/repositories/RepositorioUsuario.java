package com.educandoweb.cursojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.cursojpa.entities.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
