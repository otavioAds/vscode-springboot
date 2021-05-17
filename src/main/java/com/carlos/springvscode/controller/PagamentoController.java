package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;


import com.carlos.springvscode.domain.Pagamento;
import com.carlos.springvscode.services.PagamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/Pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pagamento> getById(@PathVariable Integer id) {


        Pagamento pag = service.find(id);
        return ResponseEntity.ok().body(pag);
    }

}
