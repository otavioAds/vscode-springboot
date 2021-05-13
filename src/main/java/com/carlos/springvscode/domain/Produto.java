package com.carlos.springvscode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import lombok.Data;

@Entity
@Data
public class Produto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    private String nome;
    private Double preco;

    @ManyToMany
    @JoinTable(
        name = "PRODUTO_CATEGORIA", 
        joinColumns = {@JoinColumn(name = "produto_id")},
        inverseJoinColumns = {@JoinColumn(name = "categoria_id")}
    )
    private List<Categoria> categorias = new ArrayList<>();

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    

    
}
