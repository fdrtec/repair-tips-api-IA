package com.repairsystem.controller;

import com.repairsystem.dto.request.FabricanteRequestDTO;
import com.repairsystem.dto.response.FabricanteResponseDTO;
import com.repairsystem.service.FabricanteService;
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
@RequestMapping("/v1/fabricantes")
@RequiredArgsConstructor
public class FabricanteController {

    private final FabricanteService service;

    @PostMapping
    public ResponseEntity<FabricanteResponseDTO> criar(@Valid @RequestBody FabricanteRequestDTO requestDTO) {
        log.info("POST /v1/fabricantes - Criando novo fabricante: {}", requestDTO.nome());
        var response = service.criar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<FabricanteResponseDTO>> listar(Pageable pageable) {
        log.info("GET /v1/fabricantes - Listando fabricantes com paginação");
        var response = service.listar(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<FabricanteResponseDTO>> listarTodos() {
        log.info("GET /v1/fabricantes/todos - Listando todos os fabricantes");
        var response = service.listarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> obterPorId(@PathVariable Long id) {
        log.info("GET /v1/fabricantes/{} - Obtendo fabricante por ID", id);
        var response = service.obterPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<FabricanteResponseDTO> obterPorNome(@PathVariable String nome) {
        log.info("GET /v1/fabricantes/nome/{} - Obtendo fabricante por nome", nome);
        var response = service.obterPorNome(nome);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody FabricanteRequestDTO requestDTO) {
        log.info("PUT /v1/fabricantes/{} - Atualizando fabricante", id);
        var response = service.atualizar(id, requestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("DELETE /v1/fabricantes/{} - Deletando fabricante", id);
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
