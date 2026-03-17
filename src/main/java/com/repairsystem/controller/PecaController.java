package com.repairsystem.controller;

import com.repairsystem.dto.request.PecaRequestDTO;
import com.repairsystem.dto.response.PecaResponseDTO;
import com.repairsystem.service.PecaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/pecas")
@RequiredArgsConstructor
public class PecaController {

    private final PecaService service;

    @PostMapping
    public ResponseEntity<PecaResponseDTO> criar(@Valid @RequestBody PecaRequestDTO requestDTO) {
        log.info("POST /v1/pecas - Criando nova peça: {}", requestDTO.partNumber());
        var response = service.criar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<PecaResponseDTO>> listar(Pageable pageable) {
        log.info("GET /v1/pecas - Listando peças com paginação");
        var response = service.listar(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Page<PecaResponseDTO>> listarPorNome(
            @PathVariable String nome,
            Pageable pageable) {
        log.info("GET /v1/pecas/nome/{} - Listando por nome", nome);
        var response = service.listarPorNome(nome, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<Page<PecaResponseDTO>> listarPorCategoria(
            @PathVariable String categoria,
            Pageable pageable) {
        log.info("GET /v1/pecas/categoria/{} - Listando por categoria", categoria);
        var response = service.listarPorCategoria(categoria, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PecaResponseDTO> obterPorId(@PathVariable Long id) {
        log.info("GET /v1/pecas/{} - Obtendo peça por ID", id);
        var response = service.obterPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/part-number/{partNumber}")
    public ResponseEntity<PecaResponseDTO> obterPorPartNumber(@PathVariable String partNumber) {
        log.info("GET /v1/pecas/part-number/{} - Obtendo peça por partNumber", partNumber);
        var response = service.obterPorPartNumber(partNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<PecaResponseDTO>> buscar(
            @RequestParam String termo,
            Pageable pageable) {
        log.info("GET /v1/pecas/buscar?termo={} - Buscando peças", termo);
        var response = service.buscar(termo, pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/equipamento/{equipamentoId}")
    public ResponseEntity<Page<PecaResponseDTO>> obterPecasEquipamento(
            @PathVariable Long equipamentoId,
            Pageable pageable) {
        log.info("GET /v1/pecas/equipamento/{} - Obtendo peças do equipamento", equipamentoId);
        var response = service.obterPecasEquipamento(equipamentoId, pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PecaResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody PecaRequestDTO requestDTO) {
        log.info("PUT /v1/pecas/{} - Atualizando peça", id);
        var response = service.atualizar(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("DELETE /v1/pecas/{} - Deletando peça", id);
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
