package com.carlos.springvscode.repositories;

import com.carlos.springvscode.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer>{
    
}
