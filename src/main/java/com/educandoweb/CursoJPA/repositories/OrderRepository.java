package com.educandoweb.cursojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.cursojpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
