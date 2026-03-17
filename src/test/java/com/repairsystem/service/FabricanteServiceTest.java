package com.repairsystem.service;

import com.repairsystem.domain.entity.Fabricante;
import com.repairsystem.dto.request.FabricanteRequestDTO;
import com.repairsystem.dto.response.FabricanteResponseDTO;
import com.repairsystem.exception.DuplicateEntityException;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.mapper.FabricanteMapper;
import com.repairsystem.repository.FabricanteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("FabricanteService Tests")
class FabricanteServiceTest {

    @Mock
    private FabricanteRepository repository;

    @Mock
    private FabricanteMapper mapper;

    @InjectMocks
    private FabricanteService service;

    private FabricanteRequestDTO requestDTO;
    private Fabricante fabricante;
    private FabricanteResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        requestDTO = new FabricanteRequestDTO("HP Inc.", "HP");
        
        fabricante = Fabricante.builder()
            .id(1L)
            .nome("HP Inc.")
            .sigla("HP")
            .build();

        responseDTO = new FabricanteResponseDTO(1L, "HP Inc.", "HP");
    }

    @Test
    @DisplayName("Deve criar um novo fabricante com sucesso")
    void testCriarComSucesso() {
        // Arrange
        when(repository.existsByNome(requestDTO.nome())).thenReturn(false);
        when(repository.existsBySigla(requestDTO.sigla())).thenReturn(false);
        when(mapper.toEntity(requestDTO)).thenReturn(fabricante);
        when(repository.save(any(Fabricante.class))).thenReturn(fabricante);
        when(mapper.toResponseDTO(fabricante)).thenReturn(responseDTO);

        // Act
        FabricanteResponseDTO resultado = service.criar(requestDTO);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.nome()).isEqualTo("HP Inc.");
        assertThat(resultado.sigla()).isEqualTo("HP");
        verify(repository, times(1)).save(any(Fabricante.class));
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar fabricante com nome duplicado")
    void testCriarComNomeDuplicado() {
        // Arrange
        when(repository.existsByNome(requestDTO.nome())).thenReturn(true);

        // Act & Assert
        assertThatThrownBy(() -> service.criar(requestDTO))
            .isInstanceOf(DuplicateEntityException.class)
            .hasMessageContaining("já existe");
        
        verify(repository, never()).save(any(Fabricante.class));
    }

    @Test
    @DisplayName("Deve listar fabricantes com paginação")
    void testListarComPaginacao() {
        // Arrange
        Pageable pageable = mock(Pageable.class);
        Page<Fabricante> page = new PageImpl<>(List.of(fabricante), pageable, 1);
        when(repository.findAll(pageable)).thenReturn(page);
        when(mapper.toResponseDTO(fabricante)).thenReturn(responseDTO);

        // Act
        Page<FabricanteResponseDTO> resultado = service.listar(pageable);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.getContent()).hasSize(1);
        verify(repository, times(1)).findAll(pageable);
    }

    @Test
    @DisplayName("Deve obter fabricante por ID com sucesso")
    void testObterPorIdComSucesso() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(fabricante));
        when(mapper.toResponseDTO(fabricante)).thenReturn(responseDTO);

        // Act
        FabricanteResponseDTO resultado = service.obterPorId(1L);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.id()).isEqualTo(1L);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção ao obter fabricante inexistente")
    void testObterPorIdNaoEncontrado() {
        // Arrange
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.obterPorId(999L))
            .isInstanceOf(EntityNotFoundException.class)
            .hasMessageContaining("não encontrado");
    }

    @Test
    @DisplayName("Deve atualizar fabricante com sucesso")
    void testAtualizarComSucesso() {
        // Arrange
        FabricanteRequestDTO novaRequisicao = new FabricanteRequestDTO("HP New", "HPN");
        when(repository.findById(1L)).thenReturn(Optional.of(fabricante));
        when(repository.existsByNome("HP New")).thenReturn(false);
        when(repository.existsBySigla("HPN")).thenReturn(false);
        when(repository.save(any(Fabricante.class))).thenReturn(fabricante);
        when(mapper.toResponseDTO(fabricante)).thenReturn(responseDTO);

        // Act
        FabricanteResponseDTO resultado = service.atualizar(1L, novaRequisicao);

        // Assert
        assertThat(resultado).isNotNull();
        verify(repository, times(1)).save(any(Fabricante.class));
    }

    @Test
    @DisplayName("Deve deletar fabricante com sucesso")
    void testDeletarComSucesso() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(fabricante));

        // Act
        service.deletar(1L);

        // Assert
        verify(repository, times(1)).delete(fabricante);
    }
}
