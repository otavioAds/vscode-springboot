package com.carlos.springvscode.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Estado implements Serializable {

    private static final long serialVersionUID = 3275054358340583455L;

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private String nome;

    @Getter
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="estado", fetch = FetchType.LAZY)
    private Set<Cidade> cidades = new HashSet<>();

    public Estado() {
    }
    
    public Estado(String nome) {
        this.nome = nome;
    }

    public Cidade addCidade(Cidade cid) {
        cidades.add(cid);
        cid.setEstado(this);
        return cid;
    }
}
