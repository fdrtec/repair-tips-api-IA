package com.repairsystem.mapper;

import com.repairsystem.domain.entity.Equipamento;
import com.repairsystem.dto.request.EquipamentoRequestDTO;
import com.repairsystem.dto.response.EquipamentoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FabricanteMapper.class)
public interface EquipamentoMapper {

    @Mapping(source = "fabricante", target = "fabricante")
    EquipamentoResponseDTO toResponseDTO(Equipamento equipamento);

    Equipamento toEntity(EquipamentoRequestDTO requestDTO);
}
