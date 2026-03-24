package com.repairsystem.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * FabricanteResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class FabricanteResponseDTO {

  private Optional<Long> id = Optional.empty();

  private Optional<String> nome = Optional.empty();

  private Optional<String> sigla = Optional.empty();

  public FabricanteResponseDTO id(Long id) {
    this.id = Optional.of(id);
    return this;
  }

  /**
   * ID do fabricante
   * @return id
   */
  
  @Schema(name = "id", description = "ID do fabricante", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Optional<Long> getId() {
    return id;
  }

  public void setId(Optional<Long> id) {
    this.id = id;
  }

  public FabricanteResponseDTO nome(String nome) {
    this.nome = Optional.of(nome);
    return this;
  }

  /**
   * Nome do fabricante
   * @return nome
   */
  
  @Schema(name = "nome", description = "Nome do fabricante", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public Optional<String> getNome() {
    return nome;
  }

  public void setNome(Optional<String> nome) {
    this.nome = nome;
  }

  public FabricanteResponseDTO sigla(String sigla) {
    this.sigla = Optional.of(sigla);
    return this;
  }

  /**
   * Sigla do fabricante
   * @return sigla
   */
  
  @Schema(name = "sigla", description = "Sigla do fabricante", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sigla")
  public Optional<String> getSigla() {
    return sigla;
  }

  public void setSigla(Optional<String> sigla) {
    this.sigla = sigla;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FabricanteResponseDTO fabricanteResponseDTO = (FabricanteResponseDTO) o;
    return Objects.equals(this.id, fabricanteResponseDTO.id) &&
        Objects.equals(this.nome, fabricanteResponseDTO.nome) &&
        Objects.equals(this.sigla, fabricanteResponseDTO.sigla);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, sigla);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FabricanteResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    sigla: ").append(toIndentedString(sigla)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

