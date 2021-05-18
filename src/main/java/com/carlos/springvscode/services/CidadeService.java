
package com.carlos.springvscode.services;

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

    public Cidade find(Integer id){
        Optional<Cidade> cid = repo.findById(id);
        return cid.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Cidade.class.getName()));
              
    }    

}
