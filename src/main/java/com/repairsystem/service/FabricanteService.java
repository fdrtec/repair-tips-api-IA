package com.repairsystem.service;

import com.repairsystem.domain.entity.Fabricante;
import com.repairsystem.dto.FabricanteRequestDTO;
import com.repairsystem.dto.FabricanteResponseDTO;
import com.repairsystem.exception.DuplicateEntityException;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.repository.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FabricanteService {

    private final FabricanteRepository repository;

    @Transactional
    public FabricanteResponseDTO criar(FabricanteRequestDTO requestDTO) {
        log.debug("Criando novo fabricante: {}", requestDTO.getNome());

        validarDuplicidade(requestDTO.getNome(), requestDTO.getSigla());

        var fabricante = new Fabricante();
        fabricante.setNome(requestDTO.getNome());
        fabricante.setSigla(requestDTO.getSigla());

        var salvo = repository.save(fabricante);

        log.info("Fabricante criado com sucesso - ID: {}", salvo.getId());
        return convertToResponseDTO(salvo);
    }

    public Page<FabricanteResponseDTO> listar(Pageable pageable) {
        log.debug("Listando fabricantes com paginação");
        return repository.findAll(pageable).map(this::convertToResponseDTO);
    }

    public List<FabricanteResponseDTO> listarTodos() {
        log.debug("Listando todos os fabricantes");
        return repository.findAll().stream().map(this::convertToResponseDTO).toList();
    }

    public FabricanteResponseDTO obterPorId(Long id) {
        log.debug("Buscando fabricante com ID: {}", id);
        var fabricante = repository.findById(id).orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", id));
        return convertToResponseDTO(fabricante);
    }

    public FabricanteResponseDTO obterPorNome(String nome) {
        log.debug("Buscando fabricante com nome: {}", nome);
        var fabricante = repository.findByNome(nome)
                .orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", "nome", nome));
        return convertToResponseDTO(fabricante);
    }

    @Transactional
    public FabricanteResponseDTO atualizar(Long id, FabricanteRequestDTO requestDTO) {
        log.debug("Atualizando fabricante ID: {}", id);

        var fabricante = repository.findById(id).orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", id));

        if (!fabricante.getNome().equals(requestDTO.getNome()) && repository.existsByNome(requestDTO.getNome())) {
            throw DuplicateEntityException.ofField("Fabricante", "nome", requestDTO.getNome());
        }

        if (!fabricante.getSigla().equals(requestDTO.getSigla()) && repository.existsBySigla(requestDTO.getSigla())) {
            throw DuplicateEntityException.ofField("Fabricante", "sigla", requestDTO.getSigla());
        }

        fabricante.setNome(requestDTO.getNome());
        fabricante.setSigla(requestDTO.getSigla());

        var atualizado = repository.save(fabricante);
        log.info("Fabricante atualizado com sucesso - ID: {}", atualizado.getId());
        return convertToResponseDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        log.debug("Deletando fabricante ID: {}", id);

        var fabricante = repository.findById(id).orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", id));

        repository.delete(fabricante);
        log.info("Fabricante deletado com sucesso - ID: {}", id);
    }

    private void validarDuplicidade(String nome, String sigla) {
        if (repository.existsByNome(nome)) {
            throw DuplicateEntityException.ofField("Fabricante", "nome", nome);
        }
        if (repository.existsBySigla(sigla)) {
            throw DuplicateEntityException.ofField("Fabricante", "sigla", sigla);
        }
    }

    private FabricanteResponseDTO convertToResponseDTO(Fabricante entity) {
        return new FabricanteResponseDTO().id(entity.getId()).nome(entity.getNome()).sigla(entity.getSigla());
    }
}
