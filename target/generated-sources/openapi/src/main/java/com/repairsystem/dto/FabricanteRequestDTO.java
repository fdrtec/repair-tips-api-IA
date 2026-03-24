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
 * FabricanteRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:40:45.938316944-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class FabricanteRequestDTO {

  private String nome;

  private String sigla;

  public FabricanteRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FabricanteRequestDTO(String nome, String sigla) {
    this.nome = nome;
    this.sigla = sigla;
  }

  public FabricanteRequestDTO nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome do fabricante
   * @return nome
   */
  @NotNull @Size(min = 3, max = 100) 
  @Schema(name = "nome", description = "Nome do fabricante", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public FabricanteRequestDTO sigla(String sigla) {
    this.sigla = sigla;
    return this;
  }

  /**
   * Sigla do fabricante
   * @return sigla
   */
  @NotNull @Size(min = 2, max = 5) 
  @Schema(name = "sigla", description = "Sigla do fabricante", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sigla")
  public String getSigla() {
    return sigla;
  }

  public void setSigla(String sigla) {
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
    FabricanteRequestDTO fabricanteRequestDTO = (FabricanteRequestDTO) o;
    return Objects.equals(this.nome, fabricanteRequestDTO.nome) &&
        Objects.equals(this.sigla, fabricanteRequestDTO.sigla);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, sigla);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FabricanteRequestDTO {\n");
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

