package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;


import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.domain.Endereco;
import com.carlos.springvscode.services.ClienteService;
import com.carlos.springvscode.services.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/Enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Integer id) {

        Endereco end = service.bucar(id);
        return ResponseEntity.ok().body(end);
    }

    
    
    
    
}
