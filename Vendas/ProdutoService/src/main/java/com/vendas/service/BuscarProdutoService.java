package com.vendas.service;

import com.vendas.entity.Produto;
import com.vendas.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarProdutoService {
    IProdutoRepository produtoRepository;

    @Autowired
    public BuscarProdutoService(IProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> buscarTodosOsProdutos(Pageable pageable){
        return this.produtoRepository.findAll(pageable);
    }

    public Produto buscarProdutoPeloID(String id) throws ChangeSetPersister.NotFoundException {
        return this.produtoRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Produto findByEan(String ean){
        return this.produtoRepository.findByEan(ean);
    }

    public Boolean isProdutoExiste(String id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            System.out.println("Produto encontrado");
            return true;
        } else {
            System.out.println("Produto não encontrado");
            return false;
        }
    }
}
