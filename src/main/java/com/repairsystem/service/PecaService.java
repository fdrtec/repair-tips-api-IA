package com.repairsystem.service;

import com.repairsystem.domain.entity.Peca;
import com.repairsystem.dto.PecaRequestDTO;
import com.repairsystem.dto.PecaResponseDTO;
import com.repairsystem.exception.DuplicateEntityException;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.repository.PecaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PecaService {

    private final PecaRepository repository;

    @Transactional
    public PecaResponseDTO criar(PecaRequestDTO requestDTO) {
        log.debug("Criando nova peça: {}", requestDTO.getPartNumber());

        if (repository.existsPartNumberIgnoreCase(requestDTO.getPartNumber())) {
            throw DuplicateEntityException.ofField("Peça", "partNumber", requestDTO.getPartNumber());
        }

        var peca = new Peca();
        peca.setNome(requestDTO.getNome());
        peca.setPartNumber(requestDTO.getPartNumber());
        peca.setCategoria(requestDTO.getCategoria());
        
        var salva = repository.save(peca);

        log.info("Peça criada com sucesso - ID: {}", salva.getId());
        return convertToResponseDTO(salva);
    }

    public Page<PecaResponseDTO> listar(Pageable pageable) {
        log.debug("Listando peças com paginação");
        return repository.findAll(pageable).map(this::convertToResponseDTO);
    }

    public Page<PecaResponseDTO> listarPorNome(String nome, Pageable pageable) {
        log.debug("Listando peças por nome: {}", nome);
        return repository.findByNomeContainingIgnoreCase(nome, pageable).map(this::convertToResponseDTO);
    }

    public Page<PecaResponseDTO> listarPorCategoria(String categoria, Pageable pageable) {
        log.debug("Listando peças por categoria: {}", categoria);
        return repository.findByCategoria(categoria, pageable).map(this::convertToResponseDTO);
    }

    public PecaResponseDTO obterPorId(Long id) {
        log.debug("Buscando peça com ID: {}", id);
        var peca = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Peça", id));
        return convertToResponseDTO(peca);
    }

    public PecaResponseDTO obterPorPartNumber(String partNumber) {
        log.debug("Buscando peça com partNumber: {}", partNumber);
        var peca = repository.findByPartNumber(partNumber)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Peça", "partNumber", partNumber));
        return convertToResponseDTO(peca);
    }

    public Page<PecaResponseDTO> buscar(String termo, Pageable pageable) {
        log.debug("Buscando peças por termo: {}", termo);
        return repository.buscarPecaPorNomeOuPartNumber(termo, termo, pageable).map(this::convertToResponseDTO);
    }

    public Page<PecaResponseDTO> obterPecasEquipamento(Long equipamentoId, Pageable pageable) {
        log.debug("Buscando peças para equipamento ID: {}", equipamentoId);
        return repository.findByEquipamentoId(equipamentoId, pageable).map(this::convertToResponseDTO);
    }

    @Transactional
    public PecaResponseDTO atualizar(Long id, PecaRequestDTO requestDTO) {
        log.debug("Atualizando peça ID: {}", id);

        var peca = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Peça", id));

        if (!peca.getPartNumber().equals(requestDTO.getPartNumber()) && 
            repository.existsPartNumberIgnoreCase(requestDTO.getPartNumber())) {
            throw DuplicateEntityException.ofField("Peça", "partNumber", requestDTO.getPartNumber());
        }

        peca.setNome(requestDTO.getNome());
        peca.setPartNumber(requestDTO.getPartNumber());
        peca.setCategoria(requestDTO.getCategoria());

        var atualizada = repository.save(peca);
        log.info("Peça atualizada com sucesso - ID: {}", atualizada.getId());
        return convertToResponseDTO(atualizada);
    }

    @Transactional
    public void deletar(Long id) {
        log.debug("Deletando peça ID: {}", id);

        var peca = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Peça", id));

        repository.delete(peca);
        log.info("Peça deletada com sucesso - ID: {}", id);
    }

    private PecaResponseDTO convertToResponseDTO(Peca entity) {
        return new PecaResponseDTO()
            .id(entity.getId())
            .nome(entity.getNome())
            .partNumber(entity.getPartNumber())
            .categoria(entity.getCategoria());
    }
}
