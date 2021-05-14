package com.carlos.springvscode.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class ItemPedido implements Serializable{
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    private double desconto;
    private Integer quantidade;
    private double preco;
    
    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, double desconto, Integer quantidade, double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    

    
    
}
