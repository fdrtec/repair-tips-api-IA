package com.repairsystem.dto.request;

import com.repairsystem.domain.enums.CategoriaEquipamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EquipamentoRequestDTO(
    @NotBlank(message = "Modelo do equipamento é obrigatório")
    @Size(min = 3, max = 150, message = "Modelo deve ter entre 3 e 150 caracteres")
    String modelo,

    @NotNull(message = "Categoria do equipamento é obrigatória")
    CategoriaEquipamento categoria,

    @NotBlank(message = "Tipo do equipamento é obrigatório")
    @Size(min = 3, max = 100, message = "Tipo deve ter entre 3 e 100 caracteres")
    String tipo,

    @NotNull(message = "ID do fabricante é obrigatório")
    Long fabricanteId
) {}
