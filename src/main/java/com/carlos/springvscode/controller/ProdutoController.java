package com.carlos.springvscode.controller;


import java.util.List;

import com.carlos.springvscode.controller.utils.URL;
import com.carlos.springvscode.domain.Produto;
import com.carlos.springvscode.dto.ProdutoDTO;
import com.carlos.springvscode.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service; 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> getById(@PathVariable Integer id) {
        Produto prd = service.find(id);
        return ResponseEntity.ok().body(prd);
    }

    //Meotodo para buscar por pagina
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<Page<ProdutoDTO>> findPage(
                                                    @RequestParam(value = "nome", defaultValue = "") String nome, 
                                                    @RequestParam(value = "categorias", defaultValue = "0") String categorias, 
                                                    @RequestParam(value = "page", defaultValue = "0") Integer page, 
                                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
                                                    @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
                                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        List<Integer> ids = URL.decodeIntList(categorias);
        String decode = URL.decodParam(nome);
        Page<Produto> list = service.search(decode, ids, page,linesPerPage,orderBy, direction);
        Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }
}
