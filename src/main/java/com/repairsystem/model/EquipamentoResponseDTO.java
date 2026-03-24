package com.repairsystem.model;

import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.repairsystem.domain.enums.CategoriaEquipamento;

/**
 * EquipamentoResponseDTO
 */
@Schema(name = "EquipamentoResponseDTO", description = "EquipamentoResponseDTO")
public record EquipamentoResponseDTO(

    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    Optional<Long> id,

    @Schema(name = "modelo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("modelo")
    Optional<String> modelo,

    @Schema(name = "categoria", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("categoria")
    Optional<CategoriaEquipamento> categoria,

    @Schema(name = "tipo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("tipo")
    Optional<String> tipo,

    @Schema(name = "fabricante", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("fabricante")
    Optional<FabricanteResponseDTO> fabricante
) {}