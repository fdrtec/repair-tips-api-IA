package com.repairsystem.service;

import com.repairsystem.domain.entity.Dica;
import com.repairsystem.dto.request.DicaRequestDTO;
import com.repairsystem.dto.response.DicaResponseDTO;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.mapper.DicaMapper;
import com.repairsystem.repository.DicaRepository;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("DicaService Tests")
class DicaServiceTest {

    @Mock
    private DicaRepository repository;

    @Mock
    private DicaMapper mapper;

    @InjectMocks
    private DicaService service;

    private DicaRequestDTO requestDTO;
    private Dica dica;
    private DicaResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        requestDTO = new DicaRequestDTO(
            "Papel preso na impressora durante a impressão de documentos",
            "1. Desligue a impressora. 2. Abra o painel de acesso. 3. Remova o papel preso com cuidado. 4. Religue a impressora."
        );

        dica = Dica.builder()
            .id(1L)
            .problemDescricao(requestDTO.problemDescricao())
            .solucaoDescricao(requestDTO.solucaoDescricao())
            .dataCriacao(LocalDateTime.now())
            .dataAtualizacao(LocalDateTime.now())
            .ativo(true)
            .build();

        responseDTO = new DicaResponseDTO(
            1L,
            requestDTO.problemDescricao(),
            requestDTO.solucaoDescricao(),
            dica.getDataCriacao(),
            dica.getDataAtualizacao(),
            true,
            null,
            null
        );
    }

    @Test
    @DisplayName("Deve criar uma nova dica com sucesso")
    void testCriarComSucesso() {
        // Arrange
        when(mapper.toEntity(requestDTO)).thenReturn(dica);
        when(repository.save(any(Dica.class))).thenReturn(dica);
        when(mapper.toResponseDTO(dica)).thenReturn(responseDTO);

        // Act
        DicaResponseDTO resultado = service.criar(requestDTO);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.ativo()).isTrue();
        verify(repository, times(1)).save(any(Dica.class));
    }

    @Test
    @DisplayName("Deve listar dicas ativas com paginação")
    void testListarComPaginacao() {
        // Arrange
        Pageable pageable = mock(Pageable.class);
        Page<Dica> page = new PageImpl<>(List.of(dica), pageable, 1);
        when(repository.findByAtivoTrue(pageable)).thenReturn(page);
        when(mapper.toResponseDTO(dica)).thenReturn(responseDTO);

        // Act
        Page<DicaResponseDTO> resultado = service.listar(pageable);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.getContent()).hasSize(1);
        verify(repository, times(1)).findByAtivoTrue(pageable);
    }

    @Test
    @DisplayName("Deve obter dica por ID com sucesso")
    void testObterPorIdComSucesso() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(dica));
        when(mapper.toResponseDTO(dica)).thenReturn(responseDTO);

        // Act
        DicaResponseDTO resultado = service.obterPorId(1L);

        // Assert
        assertThat(resultado).isNotNull();
        assertThat(resultado.id()).isEqualTo(1L);
        verify(repository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Deve lançar exceção ao obter dica inexistente")
    void testObterPorIdNaoEncontrado() {
        // Arrange
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> service.obterPorId(999L))
            .isInstanceOf(EntityNotFoundException.class)
            .hasMessageContaining("não encontrado");
    }

    @Test
    @DisplayName("Deve deletar dica com soft delete (desativar)")
    void testDeletarComSucesso() {
        // Arrange
        dica.setAtivo(true);
        when(repository.findById(1L)).thenReturn(Optional.of(dica));
        when(repository.save(any(Dica.class))).thenReturn(dica);

        // Act
        service.deletar(1L);

        // Assert
        assertThat(dica.getAtivo()).isFalse();
        verify(repository, times(1)).save(dica);
    }

    @Test
    @DisplayName("Deve reativar uma dica deletada")
    void testReativarComSucesso() {
        // Arrange
        dica.setAtivo(false);
        when(repository.findById(1L)).thenReturn(Optional.of(dica));
        when(repository.save(any(Dica.class))).thenReturn(dica);

        // Act
        service.reativar(1L);

        // Assert
        assertThat(dica.getAtivo()).isTrue();
        verify(repository, times(1)).save(dica);
    }

    @Test
    @DisplayName("Deve buscar dicas por problema")
    void testBuscarPorProblema() {
        // Arrange
        String problema = "papel preso";
        when(repository.findByProblemaDescricaoContainingIgnoreCase(problema))
            .thenReturn(List.of(dica));
        when(mapper.toResponseDTO(dica)).thenReturn(responseDTO);

        // Act
        List<DicaResponseDTO> resultado = service.buscarPorProblema(problema);

        // Assert
        assertThat(resultado).hasSize(1);
        verify(repository, times(1)).findByProblemaDescricaoContainingIgnoreCase(problema);
    }
}
