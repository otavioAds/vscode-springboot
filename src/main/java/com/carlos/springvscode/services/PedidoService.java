package com.carlos.springvscode.services;

import java.util.Optional;

import com.carlos.springvscode.domain.Pedido;
import com.carlos.springvscode.repositories.PedidoRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
    public Pedido bucar(Integer id){

        Optional<Pedido> ped = repo.findById(id);
        return ped.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Pedido.class.getName()));
        
    }    
}
