package com.repairsystem.mapper;

import com.repairsystem.domain.entity.Fabricante;
import com.repairsystem.dto.FabricanteRequestDTO;
import com.repairsystem.dto.FabricanteResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FabricanteMapper {

    FabricanteResponseDTO toResponseDTO(Fabricante fabricante);

    Fabricante toEntity(FabricanteRequestDTO requestDTO);
}
