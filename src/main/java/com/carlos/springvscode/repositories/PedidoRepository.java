package com.carlos.springvscode.repositories;

import com.carlos.springvscode.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{

    
}
