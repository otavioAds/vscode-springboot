package com.carlos.springvscode.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class ItemPedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

    @Getter @Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pedido_id")
	private Pedido pedido;

    @Getter @Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

}
