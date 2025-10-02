package com.vendas.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProdutoQuantidade {

    @NotNull
    private Produto produto;

    @NotNull
    private Integer quantidade;

    private BigDecimal valorTotal;

    public ProdutoQuantidade(){
        this.valorTotal = BigDecimal.ZERO;
        this.quantidade = 0;
    }

    public void adicionarQuantidade(Integer quantidade){
        this.quantidade += quantidade;
        BigDecimal valorTotal = this.produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.add(valorTotal);
    }

    public void removerQuantidade(Integer quantidade){
        this.quantidade -= quantidade;
        BigDecimal novoTotal = this.produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoTotal);
    }

}
