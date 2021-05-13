package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Cidade;
import com.carlos.springvscode.repositories.CidadeRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    public Cidade bucar(Integer id){
        Optional<Cidade> prd = repo.findById(id);
        return prd.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Cidade.class.getName()));
              
    }    

    public List<Cidade>bucarAll(){

        List<Cidade> prd = repo.findAll();
        return prd;
        
    }
}
