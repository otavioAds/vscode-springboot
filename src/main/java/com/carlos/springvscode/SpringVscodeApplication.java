package com.carlos.springvscode;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.domain.Cidade;
import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.domain.Endereco;
import com.carlos.springvscode.domain.Estado;
import com.carlos.springvscode.domain.ItemPedido;
import com.carlos.springvscode.domain.PagamentoComBoleto;
import com.carlos.springvscode.domain.PagamentoComCartao;
import com.carlos.springvscode.domain.Pedido;
import com.carlos.springvscode.domain.Produto;
import com.carlos.springvscode.domain.enums.EstadoPagamento;
import com.carlos.springvscode.domain.enums.TipoCliente;
import com.carlos.springvscode.repositories.CategoriaRepository;
import com.carlos.springvscode.repositories.ClienteRepository;
import com.carlos.springvscode.repositories.EstadoRepository;
import com.carlos.springvscode.repositories.PedidoRepository;
import com.carlos.springvscode.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringVscodeApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository catRepo;

    @Autowired
    private ProdutoRepository prodRepo;

   

    @Autowired
    private EstadoRepository estRepo;

    @Autowired
    private ClienteRepository cliRepo;

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(SpringVscodeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Produto p1 = new Produto("computador", 2000.00);
        Produto p2 = new Produto("impressora", 800.00);
        Produto p3 = new Produto("mouse", 80.00);

        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");
        Categoria cat3 = new Categoria("Cama, mesa e banho");
        Categoria cat4 = new Categoria("Infra");
        Categoria cat5 = new Categoria("Gamer");
        Categoria cat6 = new Categoria("Perfumaria");

        p1.addCategoria(cat1);
        p2.addCategoria(cat1);
        p2.addCategoria(cat2);

        p3.addCategoria(cat1);

        Estado es1 = new Estado("SP");
        Estado es2 = new Estado("MG");

        Cidade cid1 = es2.addCidade(new Cidade("Uberlândia"));
        Cidade cid2 = es1.addCidade(new Cidade("São Paulo"));
        es1.addCidade(new Cidade("Campinas"));

        Cliente cli1 = new Cliente("Maria Silvia", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
        cli1.addTelefone("11974111287");
        cli1.addTelefone("11996785617");

        Endereco en1 = new Endereco("Rua flores", "300", "apt 203", "jardim", "38220834", cid1);
        Endereco en2 = new Endereco("AV Matos", "105", "sala 800", "Centro", "38777012", cid2);

        cli1.addEndereco(en1);
        cli1.addEndereco(en2);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Pedido ped1 = new Pedido(sdf.parse("30/09/2017 10:32"), cli1, en1);
        Pedido ped2 = new Pedido(sdf.parse("10/10/2017 19:32"), cli1, en2);

        ped1.setPagamento(new PagamentoComCartao(EstadoPagamento.QUITADO, 6));
        ped2.setPagamento(new PagamentoComBoleto(EstadoPagamento.PENDENTE, sdf.parse("20/10/2017 00:00")));

        ped1.addItem(new ItemPedido(p1, 0.00, 1, 2000.00));
        ped1.addItem(new ItemPedido(p3, 0.00, 2, 80.00));
        ped1.addItem(new ItemPedido(p2, 100.00, 1, 800.00));

        catRepo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
        prodRepo.saveAll(Arrays.asList(p1, p2, p3));

        estRepo.saveAll(Arrays.asList(es1, es2));

        cliRepo.save(cli1);

        pedRepo.saveAll(Arrays.asList(ped1, ped2));
    }
}
