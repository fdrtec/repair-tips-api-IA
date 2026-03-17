package com.repairsystem.controller;

import com.repairsystem.dto.request.DicaRequestDTO;
import com.repairsystem.dto.response.DicaResponseDTO;
import com.repairsystem.service.DicaService;
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
@RequestMapping("/v1/dicas")
@RequiredArgsConstructor
public class DicaController {

    private final DicaService service;

    @PostMapping
    public ResponseEntity<DicaResponseDTO> criar(@Valid @RequestBody DicaRequestDTO requestDTO) {
        log.info("POST /v1/dicas - Criando nova dica");
        var response = service.criar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<DicaResponseDTO>> listar(Pageable pageable) {
        log.info("GET /v1/dicas - Listando dicas com paginação");
        var response = service.listar(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<DicaResponseDTO>> listarTodas() {
        log.info("GET /v1/dicas/todas - Listando todas as dicas ativas");
        var response = service.listarTodas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DicaResponseDTO> obterPorId(@PathVariable Long id) {
        log.info("GET /v1/dicas/{} - Obtendo dica por ID", id);
        var response = service.obterPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar-por-problema")
    public ResponseEntity<List<DicaResponseDTO>> buscarPorProblema(@RequestParam String problema) {
        log.info("GET /v1/dicas/buscar-por-problema?problema={} - Buscando por problema", problema);
        var response = service.buscarPorProblema(problema);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/equipamento/{equipamentoId}")
    public ResponseEntity<List<DicaResponseDTO>> buscarPorEquipamento(@PathVariable Long equipamentoId) {
        log.info("GET /v1/dicas/equipamento/{} - Buscando dicas para equipamento", equipamentoId);
        var response = service.buscarPorEquipamento(equipamentoId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/peca/{pecaId}")
    public ResponseEntity<List<DicaResponseDTO>> buscarPorPeca(@PathVariable Long pecaId) {
        log.info("GET /v1/dicas/peca/{} - Buscando dicas para peça", pecaId);
        var response = service.buscarPorPeca(pecaId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fabricante/{siglFabricante}")
    public ResponseEntity<List<DicaResponseDTO>> buscarPorFabricante(@PathVariable String siglFabricante) {
        log.info("GET /v1/dicas/fabricante/{} - Buscando dicas para fabricante", siglFabricante);
        var response = service.buscarPorFabricante(siglFabricante);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DicaResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody DicaRequestDTO requestDTO) {
        log.info("PUT /v1/dicas/{} - Atualizando dica", id);
        var response = service.atualizar(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("DELETE /v1/dicas/{} - Deletando dica", id);
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/reativar")
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        log.info("POST /v1/dicas/{}/reativar - Reativando dica", id);
        service.reativar(id);
        return ResponseEntity.noContent().build();
    }
}
