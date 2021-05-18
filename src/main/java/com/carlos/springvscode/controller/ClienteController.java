package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.carlos.springvscode.domain.Cliente;
import com.carlos.springvscode.dto.ClienteDTO;
import com.carlos.springvscode.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/Clientes")
public class ClienteController {

    @Autowired
    private ClienteService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {

        Cliente cli = service.find(id);
        return ResponseEntity.ok().body(cli);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> upDate (@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDto){
        Cliente obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.upDate(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> lstCli = service.findAll();
        List<ClienteDTO> listDto = lstCli.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);        
    }

    //Meotodo para buscar por pagina
    @RequestMapping(value = "/Page" , method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page, 
                                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
                                                    @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
                                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Cliente> cat = service.finPage(page,linesPerPage,orderBy, direction);
        Page<ClienteDTO> listDto = cat.map(obj -> new ClienteDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

    
    
    
    
}
