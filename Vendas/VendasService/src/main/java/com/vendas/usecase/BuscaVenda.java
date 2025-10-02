package com.vendas.usecase;

import com.vendas.entity.Venda;
import com.vendas.exception.EntityNotFoundException;
import com.vendas.repository.IVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscaVenda {

    private IVendaRepository vendaRepository;

    @Autowired
    public BuscaVenda(IVendaRepository produtoRepository) {
        this.vendaRepository = produtoRepository;
    }

    public Page<Venda> buscar(Pageable pageable) {
        return vendaRepository.findAll(pageable);
    }

    public Venda buscarPorCodigo(String codigoVenda) {
        return vendaRepository.findBycodigoVenda(codigoVenda)
                .orElseThrow(() -> new EntityNotFoundException(Venda.class, "codigoVenda", codigoVenda));
    }
}
