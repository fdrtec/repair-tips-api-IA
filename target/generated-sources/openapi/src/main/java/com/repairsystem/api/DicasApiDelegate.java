package com.repairsystem.api;

import com.repairsystem.dto.DicaRequestDTO;
import com.repairsystem.dto.DicaResponseDTO;
import com.repairsystem.dto.PageDicaResponseDTO;
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
 * A delegate to be called by the {@link DicasApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:40:45.938316944-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public interface DicasApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /dicas : Criar nova dica
     *
     * @param dicaRequestDTO  (required)
     * @return Dica criada com sucesso (status code 201)
     * @see DicasApi#createDica
     */
    default ResponseEntity<DicaResponseDTO> createDica(DicaRequestDTO dicaRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /dicas/{id} : Deletar dica
     *
     * @param id  (required)
     * @return Dica deletada com sucesso (status code 204)
     * @see DicasApi#deleteDica
     */
    default ResponseEntity<Void> deleteDica(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /dicas/{id} : Obter dica por ID
     *
     * @param id  (required)
     * @return Dica encontrada (status code 200)
     * @see DicasApi#getDicaById
     */
    default ResponseEntity<DicaResponseDTO> getDicaById(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /dicas : Listar todas as dicas
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Lista de dicas (status code 200)
     * @see DicasApi#getDicas
     */
    default ResponseEntity<PageDicaResponseDTO> getDicas(Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /dicas/equipamento/{equipamentoId} : Buscar dicas por equipamento
     *
     * @param equipamentoId  (required)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Dicas encontradas (status code 200)
     * @see DicasApi#getDicasByEquipamento
     */
    default ResponseEntity<PageDicaResponseDTO> getDicasByEquipamento(Long equipamentoId,
        Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /dicas/{id}/reativar : Reativar dica desativada
     *
     * @param id  (required)
     * @return Dica reativada (status code 200)
     * @see DicasApi#reativarDica
     */
    default ResponseEntity<DicaResponseDTO> reativarDica(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /dicas/problema/{problema} : Buscar dicas por problema
     *
     * @param problema  (required)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Dicas encontradas (status code 200)
     * @see DicasApi#searchDicasByProblema
     */
    default ResponseEntity<PageDicaResponseDTO> searchDicasByProblema(String problema,
        Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /dicas/{id} : Atualizar dica
     *
     * @param id  (required)
     * @param dicaRequestDTO  (required)
     * @return Dica atualizada (status code 200)
     * @see DicasApi#updateDica
     */
    default ResponseEntity<DicaResponseDTO> updateDica(Long id,
        DicaRequestDTO dicaRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ativo\" : true, \"solucao\" : \"solucao\", \"equipamentoId\" : 6, \"dataAtualizacao\" : \"2000-01-23T04:56:07.000+00:00\", \"problema\" : \"problema\", \"id\" : 0, \"dataCriacao\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
