package com.carlos.springvscode.domain;


import javax.persistence.Entity;

import com.carlos.springvscode.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComCartao extends Pagamento {
    private Integer numeroDeParcela;

    public PagamentoComCartao(){
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estPagamento, Pedido pedido, Integer numeroDeParcela) {
        super(id, estPagamento, pedido);
        this.numeroDeParcela = numeroDeParcela;
    }

    public Integer getNumeroDeParcela() {
        return numeroDeParcela;
    }

    public void setNumeroDeParcela(Integer numeroDeParcela) {
        this.numeroDeParcela = numeroDeParcela;
    }

    

        
}
