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
 * DicaRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class DicaRequestDTO {

  private String problema;

  private String solucao;

  private Long equipamentoId;

  public DicaRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DicaRequestDTO(String problema, String solucao, Long equipamentoId) {
    this.problema = problema;
    this.solucao = solucao;
    this.equipamentoId = equipamentoId;
  }

  public DicaRequestDTO problema(String problema) {
    this.problema = problema;
    return this;
  }

  /**
   * Descrição do problema
   * @return problema
   */
  @NotNull 
  @Schema(name = "problema", description = "Descrição do problema", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("problema")
  public String getProblema() {
    return problema;
  }

  public void setProblema(String problema) {
    this.problema = problema;
  }

  public DicaRequestDTO solucao(String solucao) {
    this.solucao = solucao;
    return this;
  }

  /**
   * Solução para o problema
   * @return solucao
   */
  @NotNull 
  @Schema(name = "solucao", description = "Solução para o problema", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("solucao")
  public String getSolucao() {
    return solucao;
  }

  public void setSolucao(String solucao) {
    this.solucao = solucao;
  }

  public DicaRequestDTO equipamentoId(Long equipamentoId) {
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
    DicaRequestDTO dicaRequestDTO = (DicaRequestDTO) o;
    return Objects.equals(this.problema, dicaRequestDTO.problema) &&
        Objects.equals(this.solucao, dicaRequestDTO.solucao) &&
        Objects.equals(this.equipamentoId, dicaRequestDTO.equipamentoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(problema, solucao, equipamentoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DicaRequestDTO {\n");
    sb.append("    problema: ").append(toIndentedString(problema)).append("\n");
    sb.append("    solucao: ").append(toIndentedString(solucao)).append("\n");
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

