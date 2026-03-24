package com.repairsystem.api;

import com.repairsystem.dto.CategoriaEquipamento;
import com.repairsystem.dto.EquipamentoRequestDTO;
import com.repairsystem.dto.EquipamentoResponseDTO;
import com.repairsystem.dto.PageEquipamentoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link EquipamentosApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:40:45.938316944-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public interface EquipamentosApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /equipamentos : Criar novo equipamento
     *
     * @param equipamentoRequestDTO  (required)
     * @return Equipamento criado com sucesso (status code 201)
     * @see EquipamentosApi#createEquipamento
     */
    default ResponseEntity<EquipamentoResponseDTO> createEquipamento(EquipamentoRequestDTO equipamentoRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /equipamentos/{id} : Deletar equipamento
     *
     * @param id  (required)
     * @return Equipamento deletado com sucesso (status code 204)
     * @see EquipamentosApi#deleteEquipamento
     */
    default ResponseEntity<Void> deleteEquipamento(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /equipamentos/{id} : Obter equipamento por ID
     *
     * @param id  (required)
     * @return Equipamento encontrado (status code 200)
     *         or Equipamento não encontrado (status code 404)
     * @see EquipamentosApi#getEquipamentoById
     */
    default ResponseEntity<EquipamentoResponseDTO> getEquipamentoById(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /equipamentos : Listar todos os equipamentos
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Lista de equipamentos (status code 200)
     * @see EquipamentosApi#getEquipamentos
     */
    default ResponseEntity<PageEquipamentoResponseDTO> getEquipamentos(Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }, { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /equipamentos/categoria/{categoria} : Buscar equipamentos por categoria
     *
     * @param categoria  (required)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Equipamentos encontrados (status code 200)
     * @see EquipamentosApi#getEquipamentosByCategoria
     */
    default ResponseEntity<PageEquipamentoResponseDTO> getEquipamentosByCategoria(CategoriaEquipamento categoria,
        Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }, { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /equipamentos/fabricante/{fabricanteId} : Buscar equipamentos por fabricante
     *
     * @param fabricanteId  (required)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Equipamentos encontrados (status code 200)
     * @see EquipamentosApi#getEquipamentosByFabricante
     */
    default ResponseEntity<PageEquipamentoResponseDTO> getEquipamentosByFabricante(Long fabricanteId,
        Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }, { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /equipamentos/tipo/{tipo} : Buscar equipamentos por tipo
     *
     * @param tipo  (required)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Equipamentos encontrados (status code 200)
     * @see EquipamentosApi#getEquipamentosByTipo
     */
    default ResponseEntity<PageEquipamentoResponseDTO> getEquipamentosByTipo(String tipo,
        Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }, { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /equipamentos/modelo/{modelo} : Buscar equipamentos por modelo
     *
     * @param modelo  (required)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Equipamentos encontrados (status code 200)
     * @see EquipamentosApi#searchEquipamentosByModelo
     */
    default ResponseEntity<PageEquipamentoResponseDTO> searchEquipamentosByModelo(String modelo,
        Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }, { \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /equipamentos/{id} : Atualizar equipamento
     *
     * @param id  (required)
     * @param equipamentoRequestDTO  (required)
     * @return Equipamento atualizado (status code 200)
     * @see EquipamentosApi#updateEquipamento
     */
    default ResponseEntity<EquipamentoResponseDTO> updateEquipamento(Long id,
        EquipamentoRequestDTO equipamentoRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"tipo\" : \"tipo\", \"categoria\" : \"ELETRONICO\", \"id\" : 0, \"fabricanteId\" : 6, \"modelo\" : \"modelo\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
