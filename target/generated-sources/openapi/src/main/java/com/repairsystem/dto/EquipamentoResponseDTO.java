package com.repairsystem.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.repairsystem.dto.CategoriaEquipamento;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * EquipamentoResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:40:45.938316944-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class EquipamentoResponseDTO {

  private Optional<Long> id = Optional.empty();

  private Optional<String> modelo = Optional.empty();

  private Optional<CategoriaEquipamento> categoria = Optional.empty();

  private Optional<String> tipo = Optional.empty();

  private Optional<Long> fabricanteId = Optional.empty();

  public EquipamentoResponseDTO id(Long id) {
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

  public EquipamentoResponseDTO modelo(String modelo) {
    this.modelo = Optional.of(modelo);
    return this;
  }

  /**
   * Get modelo
   * @return modelo
   */
  
  @Schema(name = "modelo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("modelo")
  public Optional<String> getModelo() {
    return modelo;
  }

  public void setModelo(Optional<String> modelo) {
    this.modelo = modelo;
  }

  public EquipamentoResponseDTO categoria(CategoriaEquipamento categoria) {
    this.categoria = Optional.of(categoria);
    return this;
  }

  /**
   * Get categoria
   * @return categoria
   */
  @Valid 
  @Schema(name = "categoria", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoria")
  public Optional<CategoriaEquipamento> getCategoria() {
    return categoria;
  }

  public void setCategoria(Optional<CategoriaEquipamento> categoria) {
    this.categoria = categoria;
  }

  public EquipamentoResponseDTO tipo(String tipo) {
    this.tipo = Optional.of(tipo);
    return this;
  }

  /**
   * Get tipo
   * @return tipo
   */
  
  @Schema(name = "tipo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tipo")
  public Optional<String> getTipo() {
    return tipo;
  }

  public void setTipo(Optional<String> tipo) {
    this.tipo = tipo;
  }

  public EquipamentoResponseDTO fabricanteId(Long fabricanteId) {
    this.fabricanteId = Optional.of(fabricanteId);
    return this;
  }

  /**
   * Get fabricanteId
   * @return fabricanteId
   */
  
  @Schema(name = "fabricanteId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fabricanteId")
  public Optional<Long> getFabricanteId() {
    return fabricanteId;
  }

  public void setFabricanteId(Optional<Long> fabricanteId) {
    this.fabricanteId = fabricanteId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipamentoResponseDTO equipamentoResponseDTO = (EquipamentoResponseDTO) o;
    return Objects.equals(this.id, equipamentoResponseDTO.id) &&
        Objects.equals(this.modelo, equipamentoResponseDTO.modelo) &&
        Objects.equals(this.categoria, equipamentoResponseDTO.categoria) &&
        Objects.equals(this.tipo, equipamentoResponseDTO.tipo) &&
        Objects.equals(this.fabricanteId, equipamentoResponseDTO.fabricanteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, modelo, categoria, tipo, fabricanteId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipamentoResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    modelo: ").append(toIndentedString(modelo)).append("\n");
    sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    fabricanteId: ").append(toIndentedString(fabricanteId)).append("\n");
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

