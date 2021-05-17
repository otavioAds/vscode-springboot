package com.carlos.springvscode.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.carlos.springvscode.domain.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = -4793221892587620623L;

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String cpfOuCnpj;

    @Getter @Setter
    private Integer tpCliente;

    @Getter
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Endereco> enderecos = new HashSet<>();

    @Getter
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    @JsonIgnore
    private Set<String> telefones = new HashSet<>();// Set eh mesma coisa q list, porém nao deixa repetir

    @Getter
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String nome, String email, String cpfOuCnpj, TipoCliente tpCliente) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tpCliente = tpCliente.getCod();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpfOuCnpj == null) ? 0 : cpfOuCnpj.hashCode());
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
        Cliente other = (Cliente) obj;
        if (cpfOuCnpj == null) {
            if (other.cpfOuCnpj != null)
                return false;
        } else if (!cpfOuCnpj.equals(other.cpfOuCnpj))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [CpfOuCnpj=" + cpfOuCnpj + ", email=" + email + ", id=" + id + ", nome=" + nome + "]";
    }

    public Endereco addEndereco(Endereco en) {
        enderecos.add(en);
        en.setCliente(this);
        return en;
    }

    public String addTelefone(String tel) {
        telefones.add(tel);
        return tel;
    }
}
