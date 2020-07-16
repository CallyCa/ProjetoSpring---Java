package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;

@SpringBootApplication
public class Ds1Locadora1Application implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Ds1Locadora1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Ficção");
		Categoria cat2 = new Categoria(null, "Ação");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		
	}

}
