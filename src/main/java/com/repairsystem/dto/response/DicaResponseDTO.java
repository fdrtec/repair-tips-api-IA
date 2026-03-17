package com.repairsystem.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

public record DicaResponseDTO(
    Long id,
    String problemDescricao,
    String solucaoDescricao,
    LocalDateTime dataCriacao,
    LocalDateTime dataAtualizacao,
    Boolean ativo,
    Set<EquipamentoResponseDTO> equipamentos,
    Set<PecaResponseDTO> pecas
) {}
