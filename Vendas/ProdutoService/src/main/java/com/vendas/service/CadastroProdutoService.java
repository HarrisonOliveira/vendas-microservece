package com.vendas.service;

import com.vendas.entity.Produto;
import com.vendas.repository.IProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@Service
public class CadastroProdutoService {

    IProdutoRepository produtoRepository;
    BuscarProdutoService buscarProdutoService;

    @Autowired
    public CadastroProdutoService(IProdutoRepository produtoRepository,
                                  BuscarProdutoService buscarProdutoService){
        this.produtoRepository = produtoRepository;
        this.buscarProdutoService = buscarProdutoService;
    }

    public Produto cadastrarProduto(@Valid Produto produto){
        return this.produtoRepository.insert(produto);
    }


    public Produto editarProduto(@Valid Produto produto){
        return this.produtoRepository.save(produto);
    }

    public String excluirProduto(String id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isPresent()){
            this.produtoRepository.deleteById(id);
            return "O produto " + produto.get().getDescricao() + " foi excluído com sucesso";
        }else {
            return "Nenhum produto encontrado com o ID informado!";
        }
    }

}
