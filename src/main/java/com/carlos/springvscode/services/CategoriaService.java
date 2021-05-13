package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;
    public Categoria bucar(Integer id){

        Optional<Categoria> cat = repo.findById(id);
        return cat.orElse(null);
        
    }

    public List<Categoria >bucarAll(){

        List<Categoria> cat = repo.findAll();
        return cat;
        
    }
    
}
