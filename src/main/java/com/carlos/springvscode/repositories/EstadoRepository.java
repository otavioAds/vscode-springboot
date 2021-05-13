package com.carlos.springvscode.repositories;

import com.carlos.springvscode.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer>{
    
}
