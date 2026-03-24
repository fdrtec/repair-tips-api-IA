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
 * PecaResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class PecaResponseDTO {

  private Optional<Long> id = Optional.empty();

  private Optional<String> nome = Optional.empty();

  private Optional<String> partNumber = Optional.empty();

  private Optional<String> categoria = Optional.empty();

  private Optional<Long> equipamentoId = Optional.empty();

  public PecaResponseDTO id(Long id) {
    this.id = Optional.of(id);
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Optional<Long> getId() {
    return id;
  }

  public void setId(Optional<Long> id) {
    this.id = id;
  }

  public PecaResponseDTO nome(String nome) {
    this.nome = Optional.of(nome);
    return this;
  }

  /**
   * Get nome
   * @return nome
   */
  
  @Schema(name = "nome", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public Optional<String> getNome() {
    return nome;
  }

  public void setNome(Optional<String> nome) {
    this.nome = nome;
  }

  public PecaResponseDTO partNumber(String partNumber) {
    this.partNumber = Optional.of(partNumber);
    return this;
  }

  /**
   * Get partNumber
   * @return partNumber
   */
  
  @Schema(name = "partNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("partNumber")
  public Optional<String> getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(Optional<String> partNumber) {
    this.partNumber = partNumber;
  }

  public PecaResponseDTO categoria(String categoria) {
    this.categoria = Optional.of(categoria);
    return this;
  }

  /**
   * Get categoria
   * @return categoria
   */
  
  @Schema(name = "categoria", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoria")
  public Optional<String> getCategoria() {
    return categoria;
  }

  public void setCategoria(Optional<String> categoria) {
    this.categoria = categoria;
  }

  public PecaResponseDTO equipamentoId(Long equipamentoId) {
    this.equipamentoId = Optional.of(equipamentoId);
    return this;
  }

  /**
   * Get equipamentoId
   * @return equipamentoId
   */
  
  @Schema(name = "equipamentoId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("equipamentoId")
  public Optional<Long> getEquipamentoId() {
    return equipamentoId;
  }

  public void setEquipamentoId(Optional<Long> equipamentoId) {
    this.equipamentoId = equipamentoId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PecaResponseDTO pecaResponseDTO = (PecaResponseDTO) o;
    return Objects.equals(this.id, pecaResponseDTO.id) &&
        Objects.equals(this.nome, pecaResponseDTO.nome) &&
        Objects.equals(this.partNumber, pecaResponseDTO.partNumber) &&
        Objects.equals(this.categoria, pecaResponseDTO.categoria) &&
        Objects.equals(this.equipamentoId, pecaResponseDTO.equipamentoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, partNumber, categoria, equipamentoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PecaResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    partNumber: ").append(toIndentedString(partNumber)).append("\n");
    sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
    sb.append("    equipamentoId: ").append(toIndentedString(equipamentoId)).append("\n");
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

