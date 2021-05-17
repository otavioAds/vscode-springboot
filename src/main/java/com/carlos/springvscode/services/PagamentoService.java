package com.carlos.springvscode.services;

import java.util.Optional;

import com.carlos.springvscode.domain.Pagamento;
import com.carlos.springvscode.repositories.PagamentoRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repo;
    public Pagamento find(Integer id){

        Optional<Pagamento> pag = repo.findById(id);
        return pag.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Pagamento.class.getName()));
        
    }    
}
