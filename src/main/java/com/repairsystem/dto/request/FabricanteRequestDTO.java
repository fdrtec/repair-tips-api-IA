package com.repairsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FabricanteRequestDTO(
    @NotBlank(message = "Nome do fabricante é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    String nome,

    @NotBlank(message = "Sigla do fabricante é obrigatória")
    @Size(min = 2, max = 5, message = "Sigla deve ter entre 2 e 5 caracteres")
    String sigla
) {}
