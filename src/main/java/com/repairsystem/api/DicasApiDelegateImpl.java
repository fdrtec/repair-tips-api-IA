package com.repairsystem.api;

import com.repairsystem.dto.DicaRequestDTO;
import com.repairsystem.dto.DicaResponseDTO;
import com.repairsystem.dto.PageDicaResponseDTO;
import com.repairsystem.service.DicaService;
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
public class DicasApiDelegateImpl implements DicasApiDelegate {

    private final DicaService service;

    @Override
    public ResponseEntity<DicaResponseDTO> createDica(DicaRequestDTO dicaRequestDTO) {
        var dto = service.criar(dicaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<DicaResponseDTO> getDicaById(Long id) {
        var dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<PageDicaResponseDTO> getDicas(Optional<Integer> page, Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var pageResult = service.listar(pageable);

        var pageDTO = new PageDicaResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<PageDicaResponseDTO> searchDicasByProblema(String problema, Optional<Integer> page,
            Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        var problemas = service.buscarPorProblema(problema);
        var pageResult = new org.springframework.data.domain.PageImpl<>(problemas, pageable, problemas.size());

        var pageDTO = new PageDicaResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<PageDicaResponseDTO> getDicasByEquipamento(Long equipamentoId, Optional<Integer> page,
            Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        var equipamentos = service.buscarPorEquipamento(equipamentoId);
        var pageResult = new org.springframework.data.domain.PageImpl<>(equipamentos, pageable, equipamentos.size());

        var pageDTO = new PageDicaResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<DicaResponseDTO> updateDica(Long id, DicaRequestDTO dicaRequestDTO) {
        var dto = service.atualizar(id, dicaRequestDTO);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> deleteDica(Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<DicaResponseDTO> reativarDica(Long id) {
        service.reativar(id);
        var dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }
}
