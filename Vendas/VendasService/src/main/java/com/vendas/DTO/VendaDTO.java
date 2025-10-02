package com.vendas.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class VendaDTO {

    @NotNull
    @Size(max = 10)
    private String codigo;

    @NotNull
    private String clienteId;

    @NotNull
    private Instant dataVenda;

}
