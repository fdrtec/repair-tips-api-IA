package com.repairsystem.mapper;

import com.repairsystem.domain.entity.Dica;
import com.repairsystem.dto.request.DicaRequestDTO;
import com.repairsystem.dto.response.DicaResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, PecaMapper.class})
public interface DicaMapper {

    @Mapping(source = "equipamentos", target = "equipamentos")
    @Mapping(source = "pecas", target = "pecas")
    DicaResponseDTO toResponseDTO(Dica dica);

    Dica toEntity(DicaRequestDTO requestDTO);
}
