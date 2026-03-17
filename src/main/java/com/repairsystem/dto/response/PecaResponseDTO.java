package com.repairsystem.dto.response;

public record PecaResponseDTO(
    Long id,
    String nome,
    String partNumber,
    String categoria
) {}
