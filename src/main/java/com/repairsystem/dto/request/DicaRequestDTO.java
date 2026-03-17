package com.repairsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DicaRequestDTO(
    @NotBlank(message = "Descrição do problema é obrigatória")
    @Size(min = 50, max = 1000, message = "Descrição do problema deve ter entre 50 e 1000 caracteres")
    String problemDescricao,

    @NotBlank(message = "Descrição da solução é obrigatória")
    @Size(min = 50, max = 2000, message = "Descrição da solução deve ter entre 50 e 2000 caracteres")
    String solucaoDescricao
) {}
