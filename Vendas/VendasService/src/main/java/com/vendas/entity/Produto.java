package com.vendas.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
    private String id;

    @NotNull
    @Size(max = 50)
    private String descricao;

    @NotNull
    private String ean;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private Integer quantidade;
}
