package com.repairsystem.api;

import com.repairsystem.dto.FabricanteRequestDTO;
import com.repairsystem.dto.FabricanteResponseDTO;
import com.repairsystem.dto.PageFabricanteResponseDTO;
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
 * A delegate to be called by the {@link FabricantesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:40:45.938316944-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public interface FabricantesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /fabricantes : Criar novo fabricante
     *
     * @param fabricanteRequestDTO  (required)
     * @return Fabricante criado com sucesso (status code 201)
     *         or Dados inválidos (status code 400)
     * @see FabricantesApi#createFabricante
     */
    default ResponseEntity<FabricanteResponseDTO> createFabricante(FabricanteRequestDTO fabricanteRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"sigla\" : \"sigla\", \"nome\" : \"nome\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /fabricantes/{id} : Deletar fabricante
     *
     * @param id  (required)
     * @return Fabricante deletado com sucesso (status code 204)
     *         or Fabricante não encontrado (status code 404)
     * @see FabricantesApi#deleteFabricante
     */
    default ResponseEntity<Void> deleteFabricante(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /fabricantes/{id} : Obter fabricante por ID
     *
     * @param id  (required)
     * @return Fabricante encontrado (status code 200)
     *         or Fabricante não encontrado (status code 404)
     * @see FabricantesApi#getFabricanteById
     */
    default ResponseEntity<FabricanteResponseDTO> getFabricanteById(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"sigla\" : \"sigla\", \"nome\" : \"nome\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /fabricantes/nome/{nome} : Buscar fabricante por nome
     *
     * @param nome  (required)
     * @return Fabricante encontrado (status code 200)
     *         or Fabricante não encontrado (status code 404)
     * @see FabricantesApi#getFabricanteByNome
     */
    default ResponseEntity<FabricanteResponseDTO> getFabricanteByNome(String nome) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"sigla\" : \"sigla\", \"nome\" : \"nome\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /fabricantes : Listar todos os fabricantes
     *
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 20)
     * @return Lista de fabricantes retornada com sucesso (status code 200)
     * @see FabricantesApi#getFabricantes
     */
    default ResponseEntity<PageFabricanteResponseDTO> getFabricantes(Optional<Integer> page,
        Optional<Integer> size) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalPages\" : 1, \"currentPage\" : 5, \"content\" : [ { \"sigla\" : \"sigla\", \"nome\" : \"nome\", \"id\" : 0 }, { \"sigla\" : \"sigla\", \"nome\" : \"nome\", \"id\" : 0 } ], \"totalElements\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /fabricantes/{id} : Atualizar fabricante
     *
     * @param id  (required)
     * @param fabricanteRequestDTO  (required)
     * @return Fabricante atualizado com sucesso (status code 200)
     *         or Fabricante não encontrado (status code 404)
     * @see FabricantesApi#updateFabricante
     */
    default ResponseEntity<FabricanteResponseDTO> updateFabricante(Long id,
        FabricanteRequestDTO fabricanteRequestDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"sigla\" : \"sigla\", \"nome\" : \"nome\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
