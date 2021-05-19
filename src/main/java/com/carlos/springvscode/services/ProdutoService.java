package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.domain.Produto;
import com.carlos.springvscode.repositories.CategoriaRepository;
import com.carlos.springvscode.repositories.ProdutoRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository catRepo;

    public Produto find(Integer id){
        Optional<Produto> prd = repo.findById(id);
        return prd.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Produto.class.getName()));
              
    }    

    public List<Produto >bucarAll(){

        List<Produto> prd = repo.findAll();
        return prd;
        
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = catRepo.findAllById(ids);
        return repo.findDistinctByNomeContainingAndCategoriasIn(nome,categorias, pageRequest);
    }


}
