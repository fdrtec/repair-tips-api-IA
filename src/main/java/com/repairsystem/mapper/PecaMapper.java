package com.repairsystem.mapper;

import com.repairsystem.domain.entity.Peca;
import com.repairsystem.dto.PecaRequestDTO;
import com.repairsystem.dto.PecaResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PecaMapper {

    PecaResponseDTO toResponseDTO(Peca peca);

    Peca toEntity(PecaRequestDTO requestDTO);
}
