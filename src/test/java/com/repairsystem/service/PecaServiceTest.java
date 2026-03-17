package com.repairsystem.service;

import com.repairsystem.domain.entity.Peca;
import com.repairsystem.dto.request.PecaRequestDTO;
import com.repairsystem.dto.response.PecaResponseDTO;
import com.repairsystem.exception.DuplicateEntityException;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.mapper.PecaMapper;
import com.repairsystem.repository.PecaRepository;
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

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PecaService Tests")
class PecaServiceTest {

    @Mock
    private PecaRepository repository;

    @Mock
    private PecaMapper mapper;

    @InjectMocks
    private PecaService service;

    private PecaRequestDTO requestDTO;
    private Peca peca;
    private PecaResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        requestDTO = new PecaRequestDTO("Rolo de Pressão", "RM1-4426-000CN", "Consumível");
        
        peca = Peca.builder()
            .id(1L)
            .nome("Rolo de Pressão")
            .partNumber("RM1-4426-000CN")
            .categoria("Consumível")
            .build();

        responseDTO = new PecaResponseDTO(1L, "Rolo de Pressão", "RM1-4426-000CN", "Consumível");
    }

    @Test
    @DisplayName("Deve criar uma nova peça com sucesso")
    void testCriarComSucesso() {
        // Arrange
        when(repository.existsPartNumberIgnoreCase(requestDTO.partNumber())).thenReturn(false);
        when(mapper.toEntity(requestDTO)).thenReturn(peca);
        when(repository.save(any(Peca.class))).thenReturn(peca);
        when(mapper.toResponseDTO(peca)).thenReturn(responseDTO);

        // Act
        PecaResponseDTO resultado = service.criar(requestDTO);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.partNumber()).isEqualTo("RM1-4426-000CN");
        verify(repository, times(1)).save(any(Peca.class));
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar peça com partNumber duplicado")
    void testCriarComPartNumberDuplicado() {
        // Arrange
        when(repository.existsPartNumberIgnoreCase(requestDTO.partNumber())).thenReturn(true);

        // Act & Assert
        assertThatThrownBy(() -> service.criar(requestDTO))
            .isInstanceOf(DuplicateEntityException.class)
            .hasMessageContaining("já existe");
        
        verify(repository, never()).save(any(Peca.class));
    }

    @Test
    @DisplayName("Deve listar peças com paginação")
    void testListarComPaginacao() {
        // Arrange
        Pageable pageable = mock(Pageable.class);
        Page<Peca> page = new PageImpl<>(java.util.List.of(peca), pageable, 1);
        when(repository.findAll(pageable)).thenReturn(page);
        when(mapper.toResponseDTO(peca)).thenReturn(responseDTO);

        // Act
        Page<PecaResponseDTO> resultado = service.listar(pageable);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.getContent()).hasSize(1);
        verify(repository, times(1)).findAll(pageable);
    }

    @Test
    @DisplayName("Deve obter peça por ID com sucesso")
    void testObterPorIdComSucesso() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(peca));
        when(mapper.toResponseDTO(peca)).thenReturn(responseDTO);

        // Act
        PecaResponseDTO resultado = service.obterPorId(1L);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.id()).isEqualTo(1L);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve obter peça por partNumber com sucesso")
    void testObterPorPartNumberComSucesso() {
        // Arrange
        when(repository.findByPartNumber("RM1-4426-000CN")).thenReturn(Optional.of(peca));
        when(mapper.toResponseDTO(peca)).thenReturn(responseDTO);

        // Act
        PecaResponseDTO resultado = service.obterPorPartNumber("RM1-4426-000CN");

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.partNumber()).isEqualTo("RM1-4426-000CN");
    }

    @Test
    @DisplayName("Deve lançar exceção ao obter peça inexistente")
    void testObterPorIdNaoEncontrado() {
        // Arrange
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.obterPorId(999L))
            .isInstanceOf(EntityNotFoundException.class)
            .hasMessageContaining("não encontrado");
    }

    @Test
    @DisplayName("Deve atualizar peça com sucesso")
    void testAtualizarComSucesso() {
        // Arrange
        PecaRequestDTO novaRequisicao = new PecaRequestDTO("Novo Rolo", "RM1-NEW", "Componente");
        when(repository.findById(1L)).thenReturn(Optional.of(peca));
        when(repository.existsPartNumberIgnoreCase("RM1-NEW")).thenReturn(false);
        when(repository.save(any(Peca.class))).thenReturn(peca);
        when(mapper.toResponseDTO(peca)).thenReturn(responseDTO);

        // Act
        PecaResponseDTO resultado = service.atualizar(1L, novaRequisicao);

        // Assert
        assertThat(resultado).isNotNull();
        verify(repository, times(1)).save(any(Peca.class));
    }

    @Test
    @DisplayName("Deve deletar peça com sucesso")
    void testDeletarComSucesso() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(peca));

        // Act
        service.deletar(1L);

        // Assert
        verify(repository, times(1)).delete(peca);
    }
}
