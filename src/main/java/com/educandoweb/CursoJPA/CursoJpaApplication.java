package com.educandoweb.cursojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoJpaApplication.class, args);
		
		System.out.println("Deu certo.");
	}

}
