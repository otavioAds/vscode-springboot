package com.carlos.springvscode.dto;

import java.io.Serializable;

import com.carlos.springvscode.domain.Categoria;

import lombok.Getter;
import lombok.Setter;

public class CategoriaDTO implements Serializable{

    private static final long serialVersionUID = 1L;    

    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
    }

    
    
}
