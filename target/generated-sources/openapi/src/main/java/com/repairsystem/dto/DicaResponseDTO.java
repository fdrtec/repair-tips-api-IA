package com.repairsystem.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DicaResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class DicaResponseDTO {

  private Optional<Long> id = Optional.empty();

  private Optional<String> problema = Optional.empty();

  private Optional<String> solucao = Optional.empty();

  private Optional<Long> equipamentoId = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> dataCriacao = Optional.empty();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Optional<OffsetDateTime> dataAtualizacao = Optional.empty();

  private Optional<Boolean> ativo = Optional.empty();

  public DicaResponseDTO id(Long id) {
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

  public DicaResponseDTO problema(String problema) {
    this.problema = Optional.of(problema);
    return this;
  }

  /**
   * Get problema
   * @return problema
   */
  
  @Schema(name = "problema", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("problema")
  public Optional<String> getProblema() {
    return problema;
  }

  public void setProblema(Optional<String> problema) {
    this.problema = problema;
  }

  public DicaResponseDTO solucao(String solucao) {
    this.solucao = Optional.of(solucao);
    return this;
  }

  /**
   * Get solucao
   * @return solucao
   */
  
  @Schema(name = "solucao", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("solucao")
  public Optional<String> getSolucao() {
    return solucao;
  }

  public void setSolucao(Optional<String> solucao) {
    this.solucao = solucao;
  }

  public DicaResponseDTO equipamentoId(Long equipamentoId) {
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

  public DicaResponseDTO dataCriacao(OffsetDateTime dataCriacao) {
    this.dataCriacao = Optional.of(dataCriacao);
    return this;
  }

  /**
   * Get dataCriacao
   * @return dataCriacao
   */
  @Valid 
  @Schema(name = "dataCriacao", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataCriacao")
  public Optional<OffsetDateTime> getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(Optional<OffsetDateTime> dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public DicaResponseDTO dataAtualizacao(OffsetDateTime dataAtualizacao) {
    this.dataAtualizacao = Optional.of(dataAtualizacao);
    return this;
  }

  /**
   * Get dataAtualizacao
   * @return dataAtualizacao
   */
  @Valid 
  @Schema(name = "dataAtualizacao", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataAtualizacao")
  public Optional<OffsetDateTime> getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(Optional<OffsetDateTime> dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
  }

  public DicaResponseDTO ativo(Boolean ativo) {
    this.ativo = Optional.of(ativo);
    return this;
  }

  /**
   * Get ativo
   * @return ativo
   */
  
  @Schema(name = "ativo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ativo")
  public Optional<Boolean> getAtivo() {
    return ativo;
  }

  public void setAtivo(Optional<Boolean> ativo) {
    this.ativo = ativo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DicaResponseDTO dicaResponseDTO = (DicaResponseDTO) o;
    return Objects.equals(this.id, dicaResponseDTO.id) &&
        Objects.equals(this.problema, dicaResponseDTO.problema) &&
        Objects.equals(this.solucao, dicaResponseDTO.solucao) &&
        Objects.equals(this.equipamentoId, dicaResponseDTO.equipamentoId) &&
        Objects.equals(this.dataCriacao, dicaResponseDTO.dataCriacao) &&
        Objects.equals(this.dataAtualizacao, dicaResponseDTO.dataAtualizacao) &&
        Objects.equals(this.ativo, dicaResponseDTO.ativo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, problema, solucao, equipamentoId, dataCriacao, dataAtualizacao, ativo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DicaResponseDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    problema: ").append(toIndentedString(problema)).append("\n");
    sb.append("    solucao: ").append(toIndentedString(solucao)).append("\n");
    sb.append("    equipamentoId: ").append(toIndentedString(equipamentoId)).append("\n");
    sb.append("    dataCriacao: ").append(toIndentedString(dataCriacao)).append("\n");
    sb.append("    dataAtualizacao: ").append(toIndentedString(dataAtualizacao)).append("\n");
    sb.append("    ativo: ").append(toIndentedString(ativo)).append("\n");
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

