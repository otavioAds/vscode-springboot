package com.carlos.springvscode.repositories;

import com.carlos.springvscode.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

    
}
