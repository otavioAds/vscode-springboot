
package com.carlos.springvscode.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ClienteNewDTO implements Serializable{

    private static final long serialVersionUID = 1L; 

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String cpfOuCnpj;

    @Getter @Setter
    private Integer tpCliente;

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
    private String telefone1;

    @Getter @Setter
    private String telefone2;

    @Getter @Setter
    private String telefone3;
    
    @Getter @Setter
    private Integer cidadeId;

    public ClienteNewDTO() {
    }

    
}
