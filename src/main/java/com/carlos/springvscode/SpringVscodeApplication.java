package com.carlos.springvscode;


import java.util.Arrays;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.domain.Cidade;
import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.domain.Endereco;
import com.carlos.springvscode.domain.Estado;
import com.carlos.springvscode.domain.Produto;
import com.carlos.springvscode.domain.enums.TipoCliente;
import com.carlos.springvscode.repositories.CategoriaRepository;
import com.carlos.springvscode.repositories.CidadeRepository;
import com.carlos.springvscode.repositories.ClienteRepository;
import com.carlos.springvscode.repositories.EnderecoRepository;
import com.carlos.springvscode.repositories.EstadoRepository;
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

	@Autowired
	private CidadeRepository cidRepo;

	@Autowired
	private EstadoRepository estRepo;

	@Autowired
	private ClienteRepository cliRepo;

	@Autowired
	private EnderecoRepository endRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringVscodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);

		Estado es1 = new Estado (null,"SP");
		Estado es2 = new Estado(null,"MG");

		Cidade c1 = new Cidade(null,"Uberlândia",es2);
		Cidade c2 = new Cidade(null,"São Paulo",es1);
		Cidade c3 = new Cidade(null,"Campinas",es1);

		es1.getCidade().addAll(Arrays.asList(c2,c3));
		es2.getCidade().add(c1);

		Cliente cli1 = new Cliente(null,"Maria Silvia", "maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("11974111287","11996785617"));

		Endereco en1 = new Endereco(null,"Rua flores","300","apt 203","jardim","38220834",cli1,c1);
		Endereco en2 = new Endereco(null,"AV Matos","105","sala 800","Centro","38777012",cli1,c2);

		cli1.getEnderecos().addAll(Arrays.asList(en1,en2));

		catRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
		estRepo.saveAll(Arrays.asList(es1,es2));
		cidRepo.saveAll(Arrays.asList(c1,c2,c3));
		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(en1,en2));
		
	}

}
