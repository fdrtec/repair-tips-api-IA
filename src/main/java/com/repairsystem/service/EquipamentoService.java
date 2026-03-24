package com.repairsystem.service;

import com.repairsystem.domain.entity.Equipamento;
import com.repairsystem.domain.enums.CategoriaEquipamento;
import com.repairsystem.dto.EquipamentoRequestDTO;
import com.repairsystem.dto.EquipamentoResponseDTO;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.repository.EquipamentoRepository;
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
public class EquipamentoService {

    private final EquipamentoRepository repository;
    private final FabricanteRepository fabricanteRepository;

    @Transactional
    public EquipamentoResponseDTO criar(EquipamentoRequestDTO requestDTO) {
        log.debug("Criando novo equipamento: {}", requestDTO.getModelo());

        var fabricante = fabricanteRepository.findById(requestDTO.getFabricanteId())
                .orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", requestDTO.getFabricanteId()));

        var equipamento = new Equipamento();
        equipamento.setModelo(requestDTO.getModelo());
        equipamento.setCategoria(toDomainCategoria(requestDTO.getCategoria()));
        equipamento.setTipo(requestDTO.getTipo());
        equipamento.setFabricante(fabricante);

        var salvo = repository.save(equipamento);

        log.info("Equipamento criado com sucesso - ID: {}", salvo.getId());
        return convertToResponseDTO(salvo);
    }

    public Page<EquipamentoResponseDTO> listar(Pageable pageable) {
        log.debug("Listando equipamentos com paginação");
        return repository.findAll(pageable).map(this::convertToResponseDTO);
    }

    public Page<EquipamentoResponseDTO> listarPorCategoria(CategoriaEquipamento categoria, Pageable pageable) {
        log.debug("Listando equipamentos por categoria: {}", categoria);
        return repository.findByCategoria(categoria, pageable).map(this::convertToResponseDTO);
    }

    public Page<EquipamentoResponseDTO> listarPorTipo(String tipo, Pageable pageable) {
        log.debug("Listando equipamentos por tipo: {}", tipo);
        return repository.findByTipo(tipo, pageable).map(this::convertToResponseDTO);
    }

    public Page<EquipamentoResponseDTO> listarPorFabricante(Long fabricanteId, Pageable pageable) {
        log.debug("Listando equipamentos por fabricante ID: {}", fabricanteId);
        verificarFabricanteExiste(fabricanteId);
        return repository.findByFabricanteId(fabricanteId, pageable).map(this::convertToResponseDTO);
    }

    public EquipamentoResponseDTO obterPorId(Long id) {
        log.debug("Buscando equipamento com ID: {}", id);
        var equipamento = repository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.ofEntity("Equipamento", id));
        return convertToResponseDTO(equipamento);
    }

    public List<EquipamentoResponseDTO> buscarPorModelo(String modelo) {
        log.debug("Buscando equipamentos por modelo: {}", modelo);
        return repository.findByModeloContainingIgnoreCase(modelo).stream().map(this::convertToResponseDTO).toList();
    }

    @Transactional
    public EquipamentoResponseDTO atualizar(Long id, EquipamentoRequestDTO requestDTO) {
        log.debug("Atualizando equipamento ID: {}", id);

        var equipamento = repository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.ofEntity("Equipamento", id));

        var fabricante = fabricanteRepository.findById(requestDTO.getFabricanteId())
                .orElseThrow(() -> EntityNotFoundException.ofEntity("Fabricante", requestDTO.getFabricanteId()));

        equipamento.setModelo(requestDTO.getModelo());
        equipamento.setCategoria(toDomainCategoria(requestDTO.getCategoria()));
        equipamento.setTipo(requestDTO.getTipo());
        equipamento.setFabricante(fabricante);

        var atualizado = repository.save(equipamento);
        log.info("Equipamento atualizado com sucesso - ID: {}", atualizado.getId());
        return convertToResponseDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        log.debug("Deletando equipamento ID: {}", id);

        var equipamento = repository.findById(id)
                .orElseThrow(() -> EntityNotFoundException.ofEntity("Equipamento", id));

        repository.delete(equipamento);
        log.info("Equipamento deletado com sucesso - ID: {}", id);
    }

    private void verificarFabricanteExiste(Long fabricanteId) {
        if (!fabricanteRepository.existsById(fabricanteId)) {
            throw EntityNotFoundException.ofEntity("Fabricante", fabricanteId);
        }
    }

    private EquipamentoResponseDTO convertToResponseDTO(Equipamento entity) {
        return new EquipamentoResponseDTO().id(entity.getId()).modelo(entity.getModelo())
                .categoria(toDtoCategoria(entity.getCategoria())).tipo(entity.getTipo())
                .fabricanteId(entity.getFabricante().getId());
    }

    public com.repairsystem.domain.enums.CategoriaEquipamento toDomainCategoria(
            com.repairsystem.dto.CategoriaEquipamento dtoCategoria) {
        if (dtoCategoria == null) {
            throw new IllegalArgumentException("CategoriaEquipamento não pode ser nula");
        }

        return com.repairsystem.domain.enums.CategoriaEquipamento.valueOf(dtoCategoria.name());
    }

    public com.repairsystem.dto.CategoriaEquipamento toDtoCategoria(
            com.repairsystem.domain.enums.CategoriaEquipamento entityCategoria) {
        if (entityCategoria == null) {
            return com.repairsystem.dto.CategoriaEquipamento.OUTRO;
        }

        return com.repairsystem.dto.CategoriaEquipamento.valueOf(entityCategoria.name());
    }
}
