package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;


import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.services.CategoriaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class HelloController {


    private CategoriaService service; 

    @RequestMapping(value = "/Categorias/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> GetById(@PathVariable Integer id) {


        Categoria cat = service.bucar(id);
        return ResponseEntity.ok().body(cat);
    }
    
    
    
}
