package com.vendas.controller;

import com.vendas.entity.Produto;
import com.vendas.service.BuscarProdutoService;
import com.vendas.service.CadastroProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    CadastroProdutoService cadastroProdutoService;
    BuscarProdutoService buscarProdutoService;

    @Autowired
    public ProdutoController(BuscarProdutoService buscarProdutoService,
                             CadastroProdutoService cadastroProdutoService){
        this.buscarProdutoService = buscarProdutoService;
        this.cadastroProdutoService = cadastroProdutoService;
    }

    //Métodos de cadastro
    @PostMapping(value = "/cadastro")
    @Operation(summary = "Cadastro de Produto")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody @Valid Produto produto){
        return ResponseEntity.ok(cadastroProdutoService.cadastrarProduto(produto));
    }

    @PutMapping(value = "/atualizar")
    @Operation(summary = "Atualizar informações cadastrais do Produto")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody @Valid Produto produto){
        return ResponseEntity.ok(cadastroProdutoService.editarProduto(produto));
    }

    @DeleteMapping(value = "/excluir/id/{id}")
    @Operation(summary = "Deleta um produto pelo ID")
    public ResponseEntity<String> deletarProduto(@PathVariable(value = "id", required = true) String id){
        return ResponseEntity.ok(cadastroProdutoService.excluirProduto(id));
    }

    //Métodos de pesquisa
    @GetMapping(value = "/buscar")
    @Operation(summary = "Busca todos os produtos")
    public ResponseEntity<Page<Produto>> buscarTodosOsProdutos(Pageable pageable){
        return ResponseEntity.ok(buscarProdutoService.buscarTodosOsProdutos(pageable));
    }

    @GetMapping(value = "/buscar/id/{id}")
    @Operation(summary = "Busca um produto pelo ID")
    public Produto buscarProdutoPeloID(@PathVariable(value = "id", required = true) String id) throws ChangeSetPersister.NotFoundException {
        return this.buscarProdutoService.buscarProdutoPeloID(id);
    }

    @GetMapping(value = "/buscar/ean/{ean}")
    @Operation(summary = "Busca um produto pelo código EAN")
    public Produto buscarProdutoPeloEAN(@PathVariable(value = "ean", required = true) String ean){
        return this.buscarProdutoService.findByEan(ean);
    }

    @GetMapping(value = "buscar/cadastrado/{id}")
    @Operation(summary = "Verifica se o produto existe no banco de dados")
    public ResponseEntity<Boolean> isProdutoExiste(@PathVariable(value = "id", required = true) String id){
        return ResponseEntity.status(200).body(buscarProdutoService.isProdutoExiste(id));
    }
}
