package com.repairsystem.api;

import com.repairsystem.dto.PagePecaResponseDTO;
import com.repairsystem.dto.PecaRequestDTO;
import com.repairsystem.dto.PecaResponseDTO;
import com.repairsystem.service.PecaService;
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
public class PeasApiDelegateImpl implements PeasApiDelegate {

    private final PecaService service;

    @Override
    public ResponseEntity<PecaResponseDTO> createPeca(PecaRequestDTO pecaRequestDTO) {
        var dto = service.criar(pecaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<PecaResponseDTO> getPecaById(Long id) {
        var dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<PagePecaResponseDTO> getPecas(Optional<Integer> page, Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var pageResult = service.listar(pageable);
        
        var pageDTO = new PagePecaResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));
        
        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<PecaResponseDTO> updatePeca(Long id, PecaRequestDTO pecaRequestDTO) {
        var dto = service.atualizar(id, pecaRequestDTO);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> deletePeca(Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
