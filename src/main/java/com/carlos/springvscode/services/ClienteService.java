package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.dto.ClienteDTO;
import com.carlos.springvscode.repositories.ClienteRepository;
import com.carlos.springvscode.services.exceptions.DataIntegrityException;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    public Cliente find(Integer id){

        Optional<Cliente> cat = repo.findById(id);
        return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Cliente.class.getName()));
        
    }

    public Cliente upDate (Cliente obj)
    {
        Cliente newObj = find(obj.getId());
        updateDate(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try{
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir um Cliente que contem Endereços");     
        }
    }

    public List<Cliente> findAll(){

        return repo.findAll();
        
    }


    public Page<Cliente> finPage(Integer page, Integer linesPerPage, String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDto(ClienteDTO objDto){
        return new Cliente(objDto.getNome(), objDto.getEmail(),null,null);
    }

    private void updateDate(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());

    }


    
}
