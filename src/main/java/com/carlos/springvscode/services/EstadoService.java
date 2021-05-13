package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Estado;
import com.carlos.springvscode.repositories.EstadoRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    public Estado bucar(Integer id){
        Optional<Estado> prd = repo.findById(id);
        return prd.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Estado.class.getName()));
              
    }    

    public List<Estado>bucarAll(){

        List<Estado> prd = repo.findAll();
        return prd;
        
    }
}
