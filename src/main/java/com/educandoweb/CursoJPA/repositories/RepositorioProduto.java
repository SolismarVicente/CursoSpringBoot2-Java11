package com.educandoweb.cursojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.cursojpa.entities.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {

}
