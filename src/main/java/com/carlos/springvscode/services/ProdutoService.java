package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Produto;
import com.carlos.springvscode.repositories.ProdutoRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public Produto bucar(Integer id){
        Optional<Produto> prd = repo.findById(id);
        return prd.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Produto.class.getName()));
              
    }    

    public List<Produto >bucarAll(){

        List<Produto> prd = repo.findAll();
        return prd;
        
    }
}
