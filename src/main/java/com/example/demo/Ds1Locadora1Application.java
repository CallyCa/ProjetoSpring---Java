package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Filme;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.FilmeRepository;

@SpringBootApplication
public class Ds1Locadora1Application implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	FilmeRepository filmeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Ds1Locadora1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Ficção");
		Categoria cat2 = new Categoria(null, "Ação");
		
		Filme f1 = new Filme(null, "Matrix", 5.00);
		Filme f2 = new Filme(null, "O pequenino", 6.00);
		Filme f3 = new Filme(null, "Jackie Chan", 7.00);
		
		cat1.getFilmes().addAll(Arrays.asList(f1,f2,f3));
		
		f1.getCategorias().addAll(Arrays.asList(cat1));
		f2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		f3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		filmeRepository.saveAll(Arrays.asList(f1,f2,f3));
		
	}

}
