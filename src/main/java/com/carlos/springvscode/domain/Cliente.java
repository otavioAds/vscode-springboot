package com.carlos.springvscode.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.carlos.springvscode.domain.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String CpfOuCnpj;
    private Integer tpCliente;

    @OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();//Set eh mesma coisa q list, porém nao deixa repetir
    
    @JsonIgnore
	@OneToMany(mappedBy="cliente")
    private List<Pedido> pedidos = new ArrayList<>();
    
    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tpCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        CpfOuCnpj = cpfOuCnpj;
        this.tpCliente = tpCliente.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return CpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        CpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTpCliente() {
        return TipoCliente.toEnum(tpCliente);
    }

    public void setTpCliente(TipoCliente tpCliente) {
        this.tpCliente = tpCliente.getCod();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }




    

}
