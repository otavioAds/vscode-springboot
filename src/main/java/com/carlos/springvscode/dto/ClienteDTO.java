package com.carlos.springvscode.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.services.validation.ClienteUpdate;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@ClienteUpdate 
public class ClienteDTO implements Serializable{

    private static final long serialVersionUID = 1L;  
      
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @Getter @Setter
    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message = "e-mail inválido!")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public ClienteDTO(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    


    


    
}
