package com.repairsystem.controller;

import com.repairsystem.domain.enums.CategoriaEquipamento;
import com.repairsystem.dto.request.EquipamentoRequestDTO;
import com.repairsystem.dto.response.EquipamentoResponseDTO;
import com.repairsystem.service.EquipamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService service;

    @PostMapping
    public ResponseEntity<EquipamentoResponseDTO> criar(@Valid @RequestBody EquipamentoRequestDTO requestDTO) {
        log.info("POST /v1/equipamentos - Criando novo equipamento: {}", requestDTO.modelo());
        var response = service.criar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<EquipamentoResponseDTO>> listar(Pageable pageable) {
        log.info("GET /v1/equipamentos - Listando equipamentos com paginação");
        var response = service.listar(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<Page<EquipamentoResponseDTO>> listarPorCategoria(
            @PathVariable CategoriaEquipamento categoria,
            Pageable pageable) {
        log.info("GET /v1/equipamentos/categoria/{} - Listando por categoria", categoria);
        var response = service.listarPorCategoria(categoria, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Page<EquipamentoResponseDTO>> listarPorTipo(
            @PathVariable String tipo,
            Pageable pageable) {
        log.info("GET /v1/equipamentos/tipo/{} - Listando por tipo", tipo);
        var response = service.listarPorTipo(tipo, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fabricante/{fabricanteId}")
    public ResponseEntity<Page<EquipamentoResponseDTO>> listarPorFabricante(
            @PathVariable Long fabricanteId,
            Pageable pageable) {
        log.info("GET /v1/equipamentos/fabricante/{} - Listando por fabricante", fabricanteId);
        var response = service.listarPorFabricante(fabricanteId, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoResponseDTO> obterPorId(@PathVariable Long id) {
        log.info("GET /v1/equipamentos/{} - Obtendo equipamento por ID", id);
        var response = service.obterPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar-por-modelo")
    public ResponseEntity<List<EquipamentoResponseDTO>> buscarPorModelo(@RequestParam String modelo) {
        log.info("GET /v1/equipamentos/buscar-por-modelo?modelo={} - Buscando por modelo", modelo);
        var response = service.buscarPorModelo(modelo);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EquipamentoRequestDTO requestDTO) {
        log.info("PUT /v1/equipamentos/{} - Atualizando equipamento", id);
        var response = service.atualizar(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("DELETE /v1/equipamentos/{} - Deletando equipamento", id);
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
