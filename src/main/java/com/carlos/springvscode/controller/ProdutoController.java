package com.carlos.springvscode.controller;

import java.util.List;

import com.carlos.springvscode.domain.Produto;
import com.carlos.springvscode.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Produto prd = service.bucar(id);
        return ResponseEntity.ok().body(prd);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getProdutos(){
        List<Produto> prds = service.bucarAll();
        return ResponseEntity.ok().body(prds);
    }
    
}
