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
 * PecaRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class PecaRequestDTO {

  private String nome;

  private String partNumber;

  private String categoria;

  private Long equipamentoId;

  public PecaRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PecaRequestDTO(String nome, String partNumber, String categoria, Long equipamentoId) {
    this.nome = nome;
    this.partNumber = partNumber;
    this.categoria = categoria;
    this.equipamentoId = equipamentoId;
  }

  public PecaRequestDTO nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Nome da peça
   * @return nome
   */
  @NotNull 
  @Schema(name = "nome", description = "Nome da peça", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public PecaRequestDTO partNumber(String partNumber) {
    this.partNumber = partNumber;
    return this;
  }

  /**
   * Número da parte
   * @return partNumber
   */
  @NotNull 
  @Schema(name = "partNumber", description = "Número da parte", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("partNumber")
  public String getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(String partNumber) {
    this.partNumber = partNumber;
  }

  public PecaRequestDTO categoria(String categoria) {
    this.categoria = categoria;
    return this;
  }

  /**
   * Categoria da peça
   * @return categoria
   */
  @NotNull 
  @Schema(name = "categoria", description = "Categoria da peça", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("categoria")
  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public PecaRequestDTO equipamentoId(Long equipamentoId) {
    this.equipamentoId = equipamentoId;
    return this;
  }

  /**
   * ID do equipamento
   * @return equipamentoId
   */
  @NotNull 
  @Schema(name = "equipamentoId", description = "ID do equipamento", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("equipamentoId")
  public Long getEquipamentoId() {
    return equipamentoId;
  }

  public void setEquipamentoId(Long equipamentoId) {
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
    PecaRequestDTO pecaRequestDTO = (PecaRequestDTO) o;
    return Objects.equals(this.nome, pecaRequestDTO.nome) &&
        Objects.equals(this.partNumber, pecaRequestDTO.partNumber) &&
        Objects.equals(this.categoria, pecaRequestDTO.categoria) &&
        Objects.equals(this.equipamentoId, pecaRequestDTO.equipamentoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, partNumber, categoria, equipamentoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PecaRequestDTO {\n");
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

