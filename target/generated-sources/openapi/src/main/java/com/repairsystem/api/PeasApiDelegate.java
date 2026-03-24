package com.repairsystem.api;

import com.repairsystem.dto.PagePecaResponseDTO;
import com.repairsystem.dto.PecaRequestDTO;
import com.repairsystem.dto.PecaResponseDTO;
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
 * A delegate to be called by the {@link PeasApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:40:45.938316944-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public interface PeasApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /pecas : Criar nova peça
     *
     * @param pecaRequestDTO  (required)
     * @return Peça criada com sucesso (status code 201)
     * @see PeasApi#createPeca
     */
    default ResponseEntity<PecaResponseDTO> createPeca(PecaRequestDTO pecaRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"equipamentoId\" : 6, \"categoria\" : \"categoria\", \"nome\" : \"nome\", \"partNumber\" : \"partNumber\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /pecas/{id} : Deletar peça
     *
     * @param id  (required)
     * @return Peça deletada com sucesso (status code 204)
     * @see PeasApi#deletePeca
     */
    default ResponseEntity<Void> deletePeca(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pecas/{id} : Obter peça por ID
     *
     * @param id  (required)
     * @return Peça encontrada (status code 200)
     * @see PeasApi#getPecaById
     */
    default ResponseEntity<PecaResponseDTO> getPecaById(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"equipamentoId\" : 6, \"categoria\" : \"categoria\", \"nome\" : \"nome\", \"partNumber\" : \"partNumber\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pecas : Listar todas as peças
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Lista de peças (status code 200)
     * @see PeasApi#getPecas
     */
    default ResponseEntity<PagePecaResponseDTO> getPecas(Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 5, \"currentPage\" : 5, \"content\" : [ { \"equipamentoId\" : 6, \"categoria\" : \"categoria\", \"nome\" : \"nome\", \"partNumber\" : \"partNumber\", \"id\" : 0 }, { \"equipamentoId\" : 6, \"categoria\" : \"categoria\", \"nome\" : \"nome\", \"partNumber\" : \"partNumber\", \"id\" : 0 } ], \"totalElements\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /pecas/{id} : Atualizar peça
     *
     * @param id  (required)
     * @param pecaRequestDTO  (required)
     * @return Peça atualizada (status code 200)
     * @see PeasApi#updatePeca
     */
    default ResponseEntity<PecaResponseDTO> updatePeca(Long id,
        PecaRequestDTO pecaRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"equipamentoId\" : 6, \"categoria\" : \"categoria\", \"nome\" : \"nome\", \"partNumber\" : \"partNumber\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
