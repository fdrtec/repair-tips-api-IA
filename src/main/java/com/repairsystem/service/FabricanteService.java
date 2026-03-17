package com.repairsystem.service;

import com.repairsystem.domain.entity.Fabricante;
import com.repairsystem.dto.request.FabricanteRequestDTO;
import com.repairsystem.dto.response.FabricanteResponseDTO;
import com.repairsystem.exception.DuplicateEntityException;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.mapper.FabricanteMapper;
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
    private final FabricanteMapper mapper;

    @Transactional
    public FabricanteResponseDTO criar(FabricanteRequestDTO requestDTO) {
        log.debug("Criando novo fabricante: {}", requestDTO.nome());

        validarDuplicidade(requestDTO.nome(), requestDTO.sigla());

        var fabricante = mapper.toEntity(requestDTO);
        var salvo = repository.save(fabricante);

        log.info("Fabricante criado com sucesso - ID: {}", salvo.getId());
        return mapper.toResponseDTO(salvo);
    }

    public Page<FabricanteResponseDTO> listar(Pageable pageable) {
        log.debug("Listando fabricantes com paginação");
        return repository.findAll(pageable).map(mapper::toResponseDTO);
    }

    public List<FabricanteResponseDTO> listarTodos() {
        log.debug("Listando todos os fabricantes");
        return repository.findAll().stream()
            .map(mapper::toResponseDTO)
            .toList();
    }

    public FabricanteResponseDTO obterPorId(Long id) {
        log.debug("Buscando fabricante com ID: {}", id);
        var fabricante = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", id));
        return mapper.toResponseDTO(fabricante);
    }

    public FabricanteResponseDTO obterPorNome(String nome) {
        log.debug("Buscando fabricante com nome: {}", nome);
        var fabricante = repository.findByNome(nome)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", "nome", nome));
        return mapper.toResponseDTO(fabricante);
    }

    @Transactional
    public FabricanteResponseDTO atualizar(Long id, FabricanteRequestDTO requestDTO) {
        log.debug("Atualizando fabricante ID: {}", id);

        var fabricante = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", id));

        if (!fabricante.getNome().equals(requestDTO.nome()) && repository.existsByNome(requestDTO.nome())) {
            throw DuplicateEntityException.ofField("Fabricante", "nome", requestDTO.nome());
        }

        if (!fabricante.getSigla().equals(requestDTO.sigla()) && repository.existsBySigla(requestDTO.sigla())) {
            throw DuplicateEntityException.ofField("Fabricante", "sigla", requestDTO.sigla());
        }

        fabricante.setNome(requestDTO.nome());
        fabricante.setSigla(requestDTO.sigla());

        var atualizado = repository.save(fabricante);
        log.info("Fabricante atualizado com sucesso - ID: {}", atualizado.getId());
        return mapper.toResponseDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        log.debug("Deletando fabricante ID: {}", id);

        var fabricante = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", id));

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
}
