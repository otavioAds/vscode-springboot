package com.carlos.springvscode.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.carlos.springvscode.domain.Categoria;
import com.carlos.springvscode.dto.CategoriaDTO;
import com.carlos.springvscode.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> getById(@PathVariable Integer id) {


        Categoria cat = service.find(id);
        return ResponseEntity.ok().body(cat);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> cat = service.findAll();
        List<CategoriaDTO> listDto = cat.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }




    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Categoria obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> upDate (@PathVariable Integer id, @RequestBody Categoria obj){
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


    //Meotodo para buscar por pagina
    @RequestMapping(value = "/Page" , method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page, 
                                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
                                                    @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
                                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Categoria> cat = service.finPage(page,linesPerPage,orderBy, direction);
        Page<CategoriaDTO> listDto = cat.map(obj -> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }
    
    
    
}
