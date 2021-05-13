package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.repositories.CategoriaRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;
    public Categoria bucar(Integer id){

        Optional<Categoria> cat = repo.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Categoria.class.getName()));
        
    }

    public List<Categoria >bucarAll(){

        List<Categoria> cat = repo.findAll();
        return cat;
        
    }
    
}
