package com.repairsystem.api;

import com.repairsystem.dto.CategoriaEquipamento;
import com.repairsystem.dto.EquipamentoRequestDTO;
import com.repairsystem.dto.EquipamentoResponseDTO;
import com.repairsystem.dto.PageEquipamentoResponseDTO;
import com.repairsystem.service.EquipamentoService;
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
public class EquipamentosApiDelegateImpl implements EquipamentosApiDelegate {

    private final EquipamentoService service;

    @Override
    public ResponseEntity<EquipamentoResponseDTO> createEquipamento(EquipamentoRequestDTO equipamentoRequestDTO) {
        var dto = service.criar(equipamentoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<EquipamentoResponseDTO> getEquipamentoById(Long id) {
        var dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<PageEquipamentoResponseDTO> getEquipamentos(Optional<Integer> page, Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var pageResult = service.listar(pageable);

        var pageDTO = new PageEquipamentoResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<PageEquipamentoResponseDTO> getEquipamentosByCategoria(CategoriaEquipamento categoria,
            Optional<Integer> page, Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        var categoriaEnum = service.toDomainCategoria(categoria);
        var pageResult = service.listarPorCategoria(categoriaEnum, pageable);

        var pageDTO = new PageEquipamentoResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<PageEquipamentoResponseDTO> getEquipamentosByTipo(String tipo, Optional<Integer> page,
            Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var pageResult = service.listarPorTipo(tipo, pageable);

        var pageDTO = new PageEquipamentoResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<PageEquipamentoResponseDTO> getEquipamentosByFabricante(Long fabricanteId,
            Optional<Integer> page, Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var pageResult = service.listarPorFabricante(fabricanteId, pageable);

        var pageDTO = new PageEquipamentoResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<PageEquipamentoResponseDTO> searchEquipamentosByModelo(String modelo, Optional<Integer> page,
            Optional<Integer> size) {
        int pageNum = page.orElse(0);
        int pageSize = size.orElse(20);
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        var modelos = service.buscarPorModelo(modelo);
        var pageResult = new org.springframework.data.domain.PageImpl<>(modelos, pageable, modelos.size());

        var pageDTO = new PageEquipamentoResponseDTO();
        pageDTO.setContent(pageResult.getContent());
        pageDTO.setCurrentPage(Optional.of(pageResult.getNumber()));
        pageDTO.setTotalPages(Optional.of(pageResult.getTotalPages()));
        pageDTO.setTotalElements(Optional.of(pageResult.getTotalElements()));

        return ResponseEntity.ok(pageDTO);
    }

    @Override
    public ResponseEntity<EquipamentoResponseDTO> updateEquipamento(Long id,
            EquipamentoRequestDTO equipamentoRequestDTO) {
        var dto = service.atualizar(id, equipamentoRequestDTO);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> deleteEquipamento(Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
