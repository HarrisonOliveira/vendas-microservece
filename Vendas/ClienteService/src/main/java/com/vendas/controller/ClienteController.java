package com.vendas.controller;

import com.vendas.Entity.Cliente;
import com.vendas.service.BuscarCliente;
import com.vendas.service.CadastroCliente;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    private BuscarCliente buscarCliente;
    private CadastroCliente cadastroCliente;

    @Autowired
    public ClienteController(BuscarCliente buscarCliente, CadastroCliente cadastroCliente){
        this.buscarCliente = buscarCliente;
        this.cadastroCliente = cadastroCliente;
    }

    //Métodos de cadastro de Cliente
    @PostMapping(value = "/cadastrar")
    @Operation(summary = "Cadastra um cliente")
    public ResponseEntity<Cliente> cadastarCliente(@RequestBody @Valid Cliente cliente){
        return ResponseEntity.ok(cadastroCliente.cadastrarCliente(cliente));
    }

    @PutMapping(value = "/atualizar")
    @Operation(summary = "Atualiza um cliente")
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody @Valid Cliente cliente){
        return ResponseEntity.ok(cadastroCliente.atualizarCliente(cliente));
    }

    @DeleteMapping(value = "excluir/{id}")
    @Operation(summary = "Deleta um cliente pelo ID")
    public ResponseEntity<String> deletarCliente(@PathVariable(value = "id", required = true) String id){
//        String mensagem = cadastroCliente.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(cadastroCliente.deletarCliente(id));
    }

    // Métodos de pesquisa
    @GetMapping(value = "/buscar")
    @Operation(summary = "Busca todos os clientes")
    public ResponseEntity<Page<Cliente>> buscar(Pageable pageable){
        return ResponseEntity.ok(buscarCliente.buscarTodosOsClientes(pageable));
    }

    @GetMapping(value = "buscar/id/{id}")
    @Operation(summary = "Busca um cliente pelo ID")
    public ResponseEntity<Cliente> buscarPorId (@PathVariable(value = "id", required = true) String id){
        return ResponseEntity.ok(buscarCliente.buscarClientePeloID(id));
    }

    @GetMapping(value = "buscar/cpf/{cpf}")
    @Operation(summary = "Busca um cliente pelo CPF")
    public ResponseEntity<Cliente> buscarPorCPF (@PathVariable(value = "cpf", required = true)String cpf){
        return ResponseEntity.ok(buscarCliente.buscarClientePeloCPF(cpf));
    }

    @GetMapping(value = "/cadastrado/{id}")
    @Operation(summary = "Verifica se o cliente existe")
    public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id){
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(buscarCliente.isCadastrado(id));
    }

}
