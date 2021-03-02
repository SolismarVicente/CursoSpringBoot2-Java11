package com.educandoweb.cursojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursojpa.entities.Category;
import com.educandoweb.cursojpa.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listarTodos() {
		return categoryRepository.findAll();
	}
	
	//findById: buscarPorCodigo
	public Category buscarPorCodigo(Long codigo) {
		Optional<Category> objetoCategory = categoryRepository.findById(codigo);
		return objetoCategory.get();
	}
	
}
