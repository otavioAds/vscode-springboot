package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.carlos.springvscode.domain.Categoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
//@RequestMapping(value = "/Categorias")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> getMethodName() {


        Categoria cat1 = new Categoria(1, "nome");
        Categoria cat2 = new Categoria(2, "carlos");
        List<Categoria> lCat = new ArrayList<>();
        lCat.add(cat1);
        lCat.add(cat2);

        return  lCat;
    }
    
    
    
}
