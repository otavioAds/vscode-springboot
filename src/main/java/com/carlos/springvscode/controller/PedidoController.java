package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;


import com.carlos.springvscode.domain.Pedido;
import com.carlos.springvscode.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/Pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> getById(@PathVariable Integer id) {


        Pedido ped = service.find(id);
        return ResponseEntity.ok().body(ped);
    }

}
