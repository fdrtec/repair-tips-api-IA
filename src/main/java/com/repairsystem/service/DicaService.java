package com.repairsystem.service;

import com.repairsystem.domain.entity.Dica;
import com.repairsystem.dto.DicaRequestDTO;
import com.repairsystem.dto.DicaResponseDTO;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.repository.DicaRepository;
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
public class DicaService {

    private final DicaRepository repository;

    @Transactional
    public DicaResponseDTO criar(DicaRequestDTO requestDTO) {
        log.debug("Criando nova dica");

        var dica = new Dica();
        dica.setProblemDescricao(requestDTO.getProblema());
        dica.setSolucaoDescricao(requestDTO.getSolucao());
        dica.setAtivo(true);
        
        var salva = repository.save(dica);

        log.info("Dica criada com sucesso - ID: {}", salva.getId());
        return convertToResponseDTO(salva);
    }

    public Page<DicaResponseDTO> listar(Pageable pageable) {
        log.debug("Listando dicas ativas com paginação");
        return repository.findByAtivoTrue(pageable).map(this::convertToResponseDTO);
    }

    public List<DicaResponseDTO> listarTodas() {
        log.debug("Listando todas as dicas ativas ordenadas por data");
        return repository.findByAtivoTrueOrderByDataCriacaoDesc()
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
    }

    public DicaResponseDTO obterPorId(Long id) {
        log.debug("Buscando dica com ID: {}", id);
        var dica = repository.findById(id)
            .filter(d -> d.getAtivo() == Boolean.TRUE)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Dica", id));
        return convertToResponseDTO(dica);
    }

    public List<DicaResponseDTO> buscarPorProblema(String problema) {
        log.debug("Buscando dicas por problema: {}", problema);
        return repository.findByProblemaDescricaoContainingIgnoreCase(problema)
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
    }

    public List<DicaResponseDTO> buscarPorEquipamento(Long equipamentoId) {
        log.debug("Buscando dicas para equipamento ID: {}", equipamentoId);
        return repository.findByEquipamentoIdAndAtivoTrue(equipamentoId)
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
    }

    public List<DicaResponseDTO> buscarPorPeca(Long pecaId) {
        log.debug("Buscando dicas para peça ID: {}", pecaId);
        return repository.findByPecaIdAndAtivoTrue(pecaId)
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
    }

    public List<DicaResponseDTO> buscarPorFabricante(String siglFabricante) {
        log.debug("Buscando dicas para fabricante: {}", siglFabricante);
        return repository.findByFabricanteSiglaAndAtivoTrue(siglFabricante)
            .stream()
            .map(this::convertToResponseDTO)
            .toList();
    }

    @Transactional
    public DicaResponseDTO atualizar(Long id, DicaRequestDTO requestDTO) {
        log.debug("Atualizando dica ID: {}", id);

        var dica = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Dica", id));

        dica.setProblemDescricao(requestDTO.getProblema());
        dica.setSolucaoDescricao(requestDTO.getSolucao());

        var atualizada = repository.save(dica);
        log.info("Dica atualizada com sucesso - ID: {}", atualizada.getId());
        return convertToResponseDTO(atualizada);
    }

    @Transactional
    public void deletar(Long id) {
        log.debug("Deletando dica ID: {}", id);

        var dica = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Dica", id));

        dica.setAtivo(false);
        repository.save(dica);
        log.info("Dica deletada com sucesso (soft delete) - ID: {}", id);
    }

    @Transactional
    public void reativar(Long id) {
        log.debug("Reativando dica ID: {}", id);

        var dica = repository.findById(id)
            .orElseThrow(() -> EntityNotFoundException.ofEntity("Dica", id));

        dica.setAtivo(true);
        repository.save(dica);
        log.info("Dica reativada com sucesso - ID: {}", id);
    }

    private DicaResponseDTO convertToResponseDTO(Dica entity) {
        return new DicaResponseDTO()
            .id(entity.getId())
            .problema(entity.getProblemDescricao())
            .solucao(entity.getSolucaoDescricao())
            .dataCriacao(java.time.OffsetDateTime.of(entity.getDataCriacao().toLocalDate().atStartOfDay(), java.time.ZoneOffset.UTC))
            .ativo(entity.getAtivo());
    }
}
