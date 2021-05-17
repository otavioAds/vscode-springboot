package com.carlos.springvscode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Produto implements Serializable{

    private static final long serialVersionUID = 4917092244354065170L;

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private Double preco;

    @Getter
    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "PRODUTO_CATEGORIA", 
        joinColumns = {@JoinColumn(name = "produto_id")},
        inverseJoinColumns = {@JoinColumn(name = "categoria_id")}
    )
    private Set<Categoria> categorias = new HashSet<>();

    @Getter
    @JsonIgnore
    @OneToMany(mappedBy = "id.produto", fetch = FetchType.LAZY)
    private Set<ItemPedido> itens = new HashSet<>();

    public Produto() {
    }

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @JsonIgnore
    public List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();
        for(ItemPedido x : itens){
            lista.add(x.getPedido());
        }
        return lista;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
    }

    public Categoria addCategoria(Categoria cat) {
        categorias.add(cat);
        return cat;
    }
}
