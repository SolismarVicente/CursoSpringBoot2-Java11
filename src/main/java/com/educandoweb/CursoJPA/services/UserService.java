package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.User;
import com.educandoweb.cursojpa.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> listarTodos() {
		return userRepository.findAll();
	}
	
	//findById: buscarPorCodigo
	public User buscarPorCodigo(Long codigo) {
		Optional<User> objetoUser = userRepository.findById(codigo);
		return objetoUser.get();
	}
	
}
