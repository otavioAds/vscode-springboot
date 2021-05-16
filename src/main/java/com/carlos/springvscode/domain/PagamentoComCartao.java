package com.carlos.springvscode.domain;


import javax.persistence.Entity;

import com.carlos.springvscode.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PagamentoComCartao extends Pagamento {

    private static final long serialVersionUID = -8608602037083413069L;

    @Getter @Setter
    private Integer numeroDeParcela;

    public PagamentoComCartao(){
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estPagamento, Pedido pedido, Integer numeroDeParcela) {
        super(id, estPagamento, pedido);
        this.numeroDeParcela = numeroDeParcela;
    }

    public PagamentoComCartao(EstadoPagamento estPagamento, Integer numeroDeParcela) {
        super(estPagamento);
        this.numeroDeParcela = numeroDeParcela;
    }
}
