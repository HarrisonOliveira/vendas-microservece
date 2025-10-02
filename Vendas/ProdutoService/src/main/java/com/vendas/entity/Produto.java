package com.vendas.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produtos")
@Schema(description = "Produto")
public class Produto {
    @Id
    @Schema(description = "ID do Produto")
    private String id;

    @NotNull
    @Size(max = 50)
    @Schema(description = "Nome do Produto", nullable = false)
    private String descricao;

    @NotNull
    @Indexed(unique = true, background = true)
    @Schema(description = "Código de barras do produto", nullable = false)
    private String ean;

    @NotNull
    @Schema(description = "Preço do produto", nullable = false)
    private BigDecimal preco;

    @NotNull
    @Schema(description = "Quantidade do produto", nullable = false)
    private Integer quantidade;
}
