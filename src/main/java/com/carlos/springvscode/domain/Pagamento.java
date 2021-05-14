package com.carlos.springvscode.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.carlos.springvscode.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{

    @Id
    private Integer id;
    private Integer estPagamento;

	@JsonIgnore
	@OneToOne
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


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public EstadoPagamento getEstPagamento() {
        return EstadoPagamento.toEnum(estPagamento);
    }


    public void setEstPagamento(EstadoPagamento estPagamento) {
        this.estPagamento = estPagamento.getCod();
    }


    public Pedido getPedido() {
        return pedido;
    }


    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    

    
    
    
}
