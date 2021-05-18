
package com.carlos.springvscode.services;

import java.util.List;
import java.util.Optional;

import com.carlos.springvscode.domain.Cidade;
import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.domain.Endereco;
import com.carlos.springvscode.domain.enums.TipoCliente;
import com.carlos.springvscode.dto.ClienteDTO;
import com.carlos.springvscode.dto.ClienteNewDTO;
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

    public Cliente insert (Cliente obj)
    {
        obj.setId(null);
        return repo.save(obj);
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


    //DTO
    public Cliente fromDto(ClienteNewDTO objDto){
        Cliente cli = new  Cliente(objDto.getNome(), 
                                    objDto.getEmail(), 
                                    objDto.getCpfOuCnpj(), 
                                    TipoCliente.toEnum(objDto.getTpCliente()));

        Cidade cid = new Cidade(null);
        cid.setId(objDto.getCidadeId());
        Endereco end =  new Endereco(null,
                                     objDto.getLogradouro(), 
                                     objDto.getNumero(), 
                                     objDto.getComplemente(), 
                                     objDto.getBairro(), 
                                     objDto.getCep(),
                                     cli,
                                     cid );

        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if (objDto.getTelefone2()!=null)
            cli.getTelefones().add(objDto.getTelefone2());
        if (objDto.getTelefone3()!=null)
            cli.getTelefones().add(objDto.getTelefone3());

        return cli;
    }

    private void updateDate(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());

    }


    
}
