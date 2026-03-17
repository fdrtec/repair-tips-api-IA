package com.repairsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repairsystem.dto.request.FabricanteRequestDTO;
import com.repairsystem.dto.response.FabricanteResponseDTO;
import com.repairsystem.exception.EntityNotFoundException;
import com.repairsystem.service.FabricanteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FabricanteController.class)
@DisplayName("FabricanteController Tests")
class FabricanteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FabricanteService service;

    private FabricanteRequestDTO requestDTO;
    private FabricanteResponseDTO responseDTO;

    @BeforeEach
    void setUp() {
        requestDTO = new FabricanteRequestDTO("HP Inc.", "HP");
        responseDTO = new FabricanteResponseDTO(1L, "HP Inc.", "HP");
    }

    @Test
    @DisplayName("Deve criar um novo fabricante e retornar 201")
    void testCriarComSucesso() throws Exception {
        // Arrange
        when(service.criar(any(FabricanteRequestDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(post("/v1/fabricantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.nome").value("HP Inc."))
            .andExpect(jsonPath("$.sigla").value("HP"));

        verify(service, times(1)).criar(any(FabricanteRequestDTO.class));
    }

    @Test
    @DisplayName("Deve retornar 400 ao criar fabricante com dados inválidos")
    void testCriarComDadosInvalidos() throws Exception {
        // Arrange
        FabricanteRequestDTO requestInvalida = new FabricanteRequestDTO("HP", "H");

        // Act & Assert
        mockMvc.perform(post("/v1/fabricantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInvalida)))
            .andExpect(status().isBadRequest());

        verify(service, never()).criar(any(FabricanteRequestDTO.class));
    }

    @Test
    @DisplayName("Deve listar fabricantes com paginação e retornar 200")
    void testListarComPaginacao() throws Exception {
        // Arrange
        Page<FabricanteResponseDTO> page = new PageImpl<>(List.of(responseDTO));
        when(service.listar(any(Pageable.class))).thenReturn(page);

        // Act & Assert
        mockMvc.perform(get("/v1/fabricantes")
                .param("page", "0")
                .param("size", "10"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[0].id").value(1L))
            .andExpect(jsonPath("$.content[0].nome").value("HP Inc."));

        verify(service, times(1)).listar(any(Pageable.class));
    }

    @Test
    @DisplayName("Deve obter fabricante por ID e retornar 200")
    void testObterPorIdComSucesso() throws Exception {
        // Arrange
        when(service.obterPorId(1L)).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(get("/v1/fabricantes/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.nome").value("HP Inc."));

        verify(service, times(1)).obterPorId(1L);
    }

    @Test
    @DisplayName("Deve retornar 404 ao obter fabricante inexistente")
    void testObterPorIdNaoEncontrado() throws Exception {
        // Arrange
        when(service.obterPorId(999L)).thenThrow(new EntityNotFoundException("Fabricante não encontrado"));

        // Act & Assert
        mockMvc.perform(get("/v1/fabricantes/999"))
            .andExpect(status().isNotFound());

        verify(service, times(1)).obterPorId(999L);
    }

    @Test
    @DisplayName("Deve atualizar fabricante e retornar 200")
    void testAtualizarComSucesso() throws Exception {
        // Arrange
        when(service.atualizar(eq(1L), any(FabricanteRequestDTO.class))).thenReturn(responseDTO);

        // Act & Assert
        mockMvc.perform(put("/v1/fabricantes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDTO)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L));

        verify(service, times(1)).atualizar(eq(1L), any(FabricanteRequestDTO.class));
    }

    @Test
    @DisplayName("Deve deletar fabricante e retornar 204")
    void testDeletarComSucesso() throws Exception {
        // Arrange
        doNothing().when(service).deletar(1L);

        // Act & Assert
        mockMvc.perform(delete("/v1/fabricantes/1"))
            .andExpect(status().isNoContent());

        verify(service, times(1)).deletar(1L);
    }
}
