package com.carlos.springvscode.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = -8682386573892344073L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Date instance;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    private Pagamento pagamento;

    @Setter @Getter
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Setter @Getter
    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco endEntrega;

    @Getter
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.pedido", fetch = FetchType.LAZY)
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Date instance, Cliente cliente, Endereco endEntrega) {
        this.instance = instance;
        this.cliente = cliente;
        this.endEntrega = endEntrega;
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
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", id=" + id + ", instance=" + instance + "]";
    }

    public ItemPedido addItem(ItemPedido itemPedido) {
        itemPedido.getId().setPedido(this);
        itens.add(itemPedido);
        return itemPedido;
    }

    public Pagamento setPagamento(Pagamento pgt) {
        pagamento = pgt;
        pgt.setPedido(this);
        return pgt;
    }
}
