package com.carlos.springvscode.repositories;

import com.carlos.springvscode.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    
}
