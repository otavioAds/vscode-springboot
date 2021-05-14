package com.carlos.springvscode.services;

import java.util.Optional;

import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.repositories.ClienteRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    public Cliente bucar(Integer id){

        Optional<Cliente> cat = repo.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Cliente.class.getName()));
        
    }


    
}
