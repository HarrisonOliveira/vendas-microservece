package com.vendas.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Document(collection = "vendas")
public class Venda {

    private String id;

    @NotNull
    @Size(max = 10)
    @Indexed(unique = true, background = true)
    private String codigoVenda;

    @NotNull
    private String clienteID;

    private Set<ProdutoQuantidade> produtos;

    private BigDecimal valorTotal;

    @NotNull
    private Instant dataDaVenda;

    @NotNull
    private StatusVenda status;


    public Venda(){
        produtos = new HashSet<>();
    }


    public void adicionarProduto(Produto produto, Integer quantidade){
        validarStatus();
        Optional<ProdutoQuantidade> listaProduto = produtos.stream()
                .filter(filter -> filter.getProduto().getEan().equals(produto.getEan()))
                .findAny();

        if(listaProduto.isPresent()){
            ProdutoQuantidade produtoEncontrado = listaProduto.get();
            produtoEncontrado.adicionarQuantidade(quantidade);
        } else {
            ProdutoQuantidade prod =
                    ProdutoQuantidade.builder()
                            .produto(produto)
                            .valorTotal(BigDecimal.ZERO)
                            .quantidade(0)
                            .build();
            prod.adicionarQuantidade(quantidade);
            produtos.add(prod);
        }

    }


    public void removerProduto(Produto produto, Integer quantidade){
        validarStatus();
        Optional<ProdutoQuantidade> buscaProduto = produtos.stream()
                .filter(filter -> filter.getProduto().getEan().equals(produto.getEan()))
                .findAny();

        if(buscaProduto.isPresent()){
            ProdutoQuantidade produtoEncontrato = buscaProduto.get();
            produtoEncontrato.removerQuantidade(quantidade);
            recalcularValorTotalDaVenda();

        }



    }
    public void removerTodosProdutos() {
        validarStatus();
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos() {
        int result = produtos.stream()
                .reduce(0, (contadorParcial, produto)
                        -> contadorParcial + produto.getQuantidade(), Integer::sum);
        return result;
    }

    public void recalcularValorTotalDaVenda() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ProdutoQuantidade prod : this.produtos) {
            valorTotal = valorTotal.add(prod.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }


    public enum StatusVenda {
        INICIADA, CONCLUIDA, CANCELADA;

        public static StatusVenda getStatus(String value){
            for (StatusVenda statusVenda : StatusVenda.values()) {
                if(statusVenda.name().equals(value)){
                    return statusVenda;
                }
            }
            return null;
        }

    }

    public void validarStatus() {
        if (this.status == StatusVenda.CONCLUIDA || this.status == StatusVenda.CANCELADA) {
            throw new UnsupportedOperationException("Não é possivel, alterar uma venda concluida ou cancelada");
        }
    }



}
