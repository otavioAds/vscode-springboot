package com.carlos.springvscode.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Endereco implements Serializable{

    private static final long serialVersionUID = 5279455301199114445L;

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private String logradouro;

    @Getter @Setter
    private String numero;

    @Getter @Setter
    private String complemente;

    @Getter @Setter
    private String bairro;

    @Getter @Setter
    private String cep;

    @Getter @Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cidade_id")
    @JsonIgnore
    private Cidade cidade;

    @Getter @Setter
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(Integer id, String logradouro, String numero, String complemente, String bairro, String cep,
            Cliente cliente, Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemente = complemente;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade = cidade;
    }

    public Endereco(String logradouro, String numero, String complemente, String bairro, String cep, Cidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemente = complemente;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((complemente == null) ? 0 : complemente.hashCode());
        result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        Endereco other = (Endereco) obj;
        if (bairro == null) {
            if (other.bairro != null)
                return false;
        } else if (!bairro.equals(other.bairro))
            return false;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        } else if (!cidade.equals(other.cidade))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (complemente == null) {
            if (other.complemente != null)
                return false;
        } else if (!complemente.equals(other.complemente))
            return false;
        if (logradouro == null) {
            if (other.logradouro != null)
                return false;
        } else if (!logradouro.equals(other.logradouro))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Endereco [bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", cliente=" + cliente
                + ", complemente=" + complemente + ", id=" + id + ", logradouro=" + logradouro + ", numero=" + numero
                + "]";
    }
}
