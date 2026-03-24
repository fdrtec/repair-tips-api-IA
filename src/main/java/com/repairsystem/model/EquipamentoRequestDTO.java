package com.repairsystem.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.repairsystem.domain.enums.CategoriaEquipamento;

/**
 * EquipamentoRequestDTO
 */
@Schema(name = "EquipamentoRequestDTO", description = "EquipamentoRequestDTO")
public record EquipamentoRequestDTO(

    @NotNull
    @Size(min = 1, max = 100)
    @Schema(name = "modelo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("modelo")
    String modelo,

    @NotNull
    @Schema(name = "categoria", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("categoria")
    CategoriaEquipamento categoria,

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(name = "tipo", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("tipo")
    String tipo,

    @NotNull
    @Schema(name = "fabricanteId", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("fabricanteId")
    Long fabricanteId
) {}