package com.educandoweb.cursojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.cursojpa.entities.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Long> {

}
