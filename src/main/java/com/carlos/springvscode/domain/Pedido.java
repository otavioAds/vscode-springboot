package com.carlos.springvscode.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Pedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date instance;
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
    private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name="cliente_id")
    private Cliente cliente;

	
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id")
    private Endereco endEntrega;

    @JsonIgnore
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Integer id, Date instance, Cliente cliente, Endereco endEntrega) {
        this.id = id;
        this.instance = instance;
        this.cliente = cliente;
        this.endEntrega = endEntrega;
    }
    


    
    
}
