package com.carlos.springvscode.services;

import java.util.Date;
import java.util.Optional;

import com.carlos.springvscode.domain.ItemPedido;
import com.carlos.springvscode.domain.PagamentoComBoleto;
import com.carlos.springvscode.domain.Pedido;
import com.carlos.springvscode.domain.enums.EstadoPagamento;
import com.carlos.springvscode.repositories.ItemPedidoRepository;
import com.carlos.springvscode.repositories.PagamentoRepository;
import com.carlos.springvscode.repositories.PedidoRepository;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepo;

    @Autowired
    private ProdutoService prodService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepo;



    public Pedido find(Integer id){

        Optional<Pedido> ped = repo.findById(id);
        return ped.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id.toString()+"t ipo: " + Pedido.class.getName()));
        
    }   
    
    @Transactional
    public Pedido insert(Pedido obj)
    {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);

        if (obj.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto,obj.getInstante());
        }

        obj = repo.save(obj);
        pagamentoRepo.save(obj.getPagamento());
        for (ItemPedido item  : obj.getItens()) {
            item.setDesconto(0.0);
            item.setPreco(prodService.find(item.getProduto().getId()).getPreco());
            item.setPedido(obj);    
        }

        itemPedidoRepo.saveAll(obj.getItens());
        return obj;       
       
    }
}
