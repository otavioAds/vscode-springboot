package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.dto.CategoriaDTO;
import com.carlos.springvscode.repositories.CategoriaRepository;
import com.carlos.springvscode.services.exceptions.DataIntegrityException;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;
    public Categoria find(Integer id){

        Optional<Categoria> cat = repo.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Categoria.class.getName()));
        
    }

    public List<Categoria> findAll(){

        return repo.findAll();
        
    }

    public List<Categoria >bucarAll(){

        List<Categoria> cat = repo.findAll();
        return cat;
        
    }

    public Categoria insert (Categoria obj)
    {
        obj.setId(null);
        return repo.save(obj);
    }
    
    public Categoria upDate (Categoria obj)
    {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id){
        find(id);
        try{
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir uma categoria que contem produtos!");     
        }
    }

    public Page<Categoria> finPage(Integer page, Integer linesPerPage, String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDTO objDto){
        return new Categoria(objDto.getNome());
    }
}
