package com.carlos.springvscode.controller;

import java.util.List;

import com.carlos.springvscode.domain.Estado;
import com.carlos.springvscode.services.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Estados")
public class EstadoController {

    @Autowired
    private EstadoService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Estado> getById(@PathVariable Integer id) {
        Estado prd = service.find(id);
        return ResponseEntity.ok().body(prd);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getProdutos(){
        List<Estado> prds = service.bucarAll();
        return ResponseEntity.ok().body(prds);
    }
    
}
