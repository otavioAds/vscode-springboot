package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Integer id) {


        Categoria cat = service.bucar(id);
        return ResponseEntity.ok().body(cat);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCategorias(){

        List<Categoria> cats = service.bucarAll();
        return ResponseEntity.ok().body(cats);
    }
    
    
    
}
