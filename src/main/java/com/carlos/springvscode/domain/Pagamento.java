package com.carlos.springvscode.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.carlos.springvscode.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
// @Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{

    private static final long serialVersionUID = 7421702734393235830L;

    @Getter @Setter
    @Id
    private Integer id;

    @Getter @Setter
    private Integer estPagamento;

    @Getter @Setter
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pedido_id")
	@MapsId
    private Pedido pedido;
    
    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estPagamento, Pedido pedido) {
        this.id = id;
        this.estPagamento = estPagamento.getCod();
        this.pedido = pedido;
    }

    public Pagamento(EstadoPagamento estPagamento) {
        this.estPagamento = estPagamento.getCod();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
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
        Pagamento other = (Pagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (pedido == null) {
            if (other.pedido != null)
                return false;
        } else if (!pedido.equals(other.pedido))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento [estPagamento=" + estPagamento + ", id=" + id + ", pedido=" + pedido + "]";
    }
}
