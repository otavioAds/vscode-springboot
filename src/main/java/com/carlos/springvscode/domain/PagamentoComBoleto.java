package com.carlos.springvscode.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.carlos.springvscode.domain.enums.EstadoPagamento;



@Entity
public class PagamentoComBoleto extends Pagamento {
    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(){        
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estPagamento, Pedido pedido, Date dataVencimento,
            Date dataPagamento) {
        super(id, estPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
    
}
