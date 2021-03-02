package com.educandoweb.cursojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.cursojpa.entities.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

}
