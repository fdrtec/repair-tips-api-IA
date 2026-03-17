package com.repairsystem.dto.response;

import com.repairsystem.domain.enums.CategoriaEquipamento;

public record EquipamentoResponseDTO(
    Long id,
    String modelo,
    CategoriaEquipamento categoria,
    String tipo,
    FabricanteResponseDTO fabricante
) {}
