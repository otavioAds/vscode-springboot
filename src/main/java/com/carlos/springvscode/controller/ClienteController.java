package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;


import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/Clientes")
public class ClienteController {

    @Autowired
    private ClienteService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Integer id) {

        Cliente cli = service.bucar(id);
        return ResponseEntity.ok().body(cli);
    }

    
    
    
    
}
