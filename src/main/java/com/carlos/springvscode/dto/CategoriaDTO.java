package com.carlos.springvscode.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.carlos.springvscode.domain.Categoria;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

public class CategoriaDTO implements Serializable{

    private static final long serialVersionUID = 1L;    

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj){
        nome = obj.getNome();
    }

    
    
}
