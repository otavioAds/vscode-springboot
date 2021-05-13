package com.carlos.springvscode;


import java.util.Arrays;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.domain.Produto;
import com.carlos.springvscode.repositories.CategoriaRepository;
import com.carlos.springvscode.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringVscodeApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catRepo;

	@Autowired
	private ProdutoRepository prodRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringVscodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto prd1 = new Produto(null, "mouse", 4.0);
		Produto prd2 = new Produto(null, "teclado", 14.0);

		catRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(prd1,prd2));
		
	}

}
