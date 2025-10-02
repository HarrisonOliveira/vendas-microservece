package com.vendas.service;

import com.vendas.Entity.Cliente;
import com.vendas.exeptions.EntityNotFoundException;
import com.vendas.repository.IClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCliente {
    private final IClienteRepository clienteRepository;
    private final BuscarCliente buscarCliente;

    @Autowired
    public CadastroCliente(IClienteRepository clienteRepository, BuscarCliente buscarCliente){
        this.clienteRepository = clienteRepository;
        this.buscarCliente = buscarCliente;
    }

    public Cliente cadastrarCliente(@Valid Cliente cliente){
        return this.clienteRepository.insert(cliente);
    }

    public Cliente atualizarCliente(@Valid Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public String deletarCliente(String id){
            if(buscarCliente.isCadastrado(id)){
                this.clienteRepository.deleteById(id);
                return "Cliente excluído com sucesso!";
            } else {
                throw new EntityNotFoundException(Cliente.class, "id", id);
            }
    }
}
