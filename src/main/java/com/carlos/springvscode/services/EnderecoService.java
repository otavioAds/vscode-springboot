package com.carlos.springvscode.services;

import java.util.Optional;

import com.carlos.springvscode.domain.Endereco;
import com.carlos.springvscode.repositories.EnderecoRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repo;
    public Endereco bucar(Integer id){

        Optional<Endereco> end = repo.findById(id);
        return end.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Endereco.class.getName()));
        
    }


    
}
