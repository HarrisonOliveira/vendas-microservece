package com.vendas.Entity;

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

@Document(collection = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Cliente", description = "Cliente")
public class Cliente {
    @Id
    @Schema(description = "ID do Cliente")
    private String id;

    @NotNull
    @Size(max = 50)
    @Schema(description = "Nome do Cliente", maxLength = 50, nullable = false)
    private String nome;

    @NotNull
    @Size(max = 50)
    @Schema(description = "Sobrenome do Cliente", maxLength = 50, nullable = false)
    private String sobrenome;


    @NotNull
    @Size(max = 11)
    @Indexed(unique = true, background = true)
    @Schema(description = "CPF do Cliente", minLength = 11, nullable = false)
    private String cpf;
}
