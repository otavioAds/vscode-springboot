package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> getById(@PathVariable Integer id) {


        Categoria cat = service.find(id);
        return ResponseEntity.ok().body(cat);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Categoria obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> upDate (@PathVariable Integer id, @RequestBody Categoria obj){
        obj.setId(id);
        obj = service.upDate(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    
    
}
