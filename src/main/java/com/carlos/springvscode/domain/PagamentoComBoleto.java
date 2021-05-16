package com.carlos.springvscode.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.carlos.springvscode.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = -4543807125633579124L;

    @Getter @Setter
    private Date dataVencimento;

    @Getter @Setter
    private Date dataPagamento;

    public PagamentoComBoleto(){        
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estPagamento, Pedido pedido, Date dataVencimento,
            Date dataPagamento) {
        super(id, estPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoComBoleto(EstadoPagamento estPagamento, Date dataVencimento) {
        super(estPagamento);
        this.dataVencimento = dataVencimento;
    }
}
