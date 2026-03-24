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
 * EquipamentoRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class EquipamentoRequestDTO {

  private String modelo;

  private CategoriaEquipamento categoria;

  private String tipo;

  private Long fabricanteId;

  public EquipamentoRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EquipamentoRequestDTO(String modelo, CategoriaEquipamento categoria, String tipo, Long fabricanteId) {
    this.modelo = modelo;
    this.categoria = categoria;
    this.tipo = tipo;
    this.fabricanteId = fabricanteId;
  }

  public EquipamentoRequestDTO modelo(String modelo) {
    this.modelo = modelo;
    return this;
  }

  /**
   * Modelo do equipamento
   * @return modelo
   */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "modelo", description = "Modelo do equipamento", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("modelo")
  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public EquipamentoRequestDTO categoria(CategoriaEquipamento categoria) {
    this.categoria = categoria;
    return this;
  }

  /**
   * Get categoria
   * @return categoria
   */
  @NotNull @Valid 
  @Schema(name = "categoria", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("categoria")
  public CategoriaEquipamento getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaEquipamento categoria) {
    this.categoria = categoria;
  }

  public EquipamentoRequestDTO tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Tipo do equipamento
   * @return tipo
   */
  @NotNull @Size(min = 1, max = 50) 
  @Schema(name = "tipo", description = "Tipo do equipamento", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tipo")
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public EquipamentoRequestDTO fabricanteId(Long fabricanteId) {
    this.fabricanteId = fabricanteId;
    return this;
  }

  /**
   * ID do fabricante
   * @return fabricanteId
   */
  @NotNull 
  @Schema(name = "fabricanteId", description = "ID do fabricante", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fabricanteId")
  public Long getFabricanteId() {
    return fabricanteId;
  }

  public void setFabricanteId(Long fabricanteId) {
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
    EquipamentoRequestDTO equipamentoRequestDTO = (EquipamentoRequestDTO) o;
    return Objects.equals(this.modelo, equipamentoRequestDTO.modelo) &&
        Objects.equals(this.categoria, equipamentoRequestDTO.categoria) &&
        Objects.equals(this.tipo, equipamentoRequestDTO.tipo) &&
        Objects.equals(this.fabricanteId, equipamentoRequestDTO.fabricanteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelo, categoria, tipo, fabricanteId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipamentoRequestDTO {\n");
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

