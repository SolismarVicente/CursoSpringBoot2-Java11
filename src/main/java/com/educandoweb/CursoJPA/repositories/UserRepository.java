package com.educandoweb.cursojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.cursojpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
