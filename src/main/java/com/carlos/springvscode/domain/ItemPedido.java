package com.carlos.springvscode.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
public class ItemPedido implements Serializable{
    
    private static final long serialVersionUID = 8982526159158550508L;

    @Getter
    @JsonIgnore
	@EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    @Getter @Setter
    private double desconto;
    
    @Getter @Setter
    private Integer quantidade;

    @Getter @Setter
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

    public ItemPedido(Produto produto, double desconto, Integer quantidade, double preco) {
        super();
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

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
  
    
}
