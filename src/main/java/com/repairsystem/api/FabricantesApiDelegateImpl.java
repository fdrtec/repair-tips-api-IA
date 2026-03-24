package com.repairsystem.api;

import com.repairsystem.dto.FabricanteRequestDTO;
import com.repairsystem.dto.FabricanteResponseDTO;
import com.repairsystem.dto.PageFabricanteResponseDTO;
import com.repairsystem.service.FabricanteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class FabricantesApiDelegateImpl implements FabricantesApiDelegate {

    private final FabricanteService service;

    @Override
    public ResponseEntity<FabricanteResponseDTO> createFabricante(FabricanteRequestDTO fabricanteRequestDTO) {
        var dto = service.criar(fabricanteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<FabricanteResponseDTO> getFabricanteById(Long id) {
        var dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<FabricanteResponseDTO> getFabricanteByNome(String nome) {
        var dto = service.obterPorNome(nome);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<PageFabricanteResponseDTO> getFabricantes(Optional<Integer> page, Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var pageResult = service.listar(pageable);
        
        var pageDTO = new PageFabricanteResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));
        
        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<FabricanteResponseDTO> updateFabricante(Long id, FabricanteRequestDTO fabricanteRequestDTO) {
        var dto = service.atualizar(id, fabricanteRequestDTO);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> deleteFabricante(Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
