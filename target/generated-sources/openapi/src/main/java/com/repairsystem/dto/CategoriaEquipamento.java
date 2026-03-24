package com.repairsystem.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Categoria do equipamento
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T23:19:45.937138696-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public enum CategoriaEquipamento {
  
  IMPRESSORA("IMPRESSORA"),
  
  SCANNER("SCANNER"),
  
  COPIADORA("COPIADORA"),
  
  MULTIFUNCIONAL("MULTIFUNCIONAL"),
  
  FAX("FAX"),
  
  PROJETOR("PROJETOR"),
  
  MONITOR("MONITOR"),
  
  COMPUTADOR("COMPUTADOR"),
  
  SERVIDOR("SERVIDOR"),
  
  IMPRESSORA_3_D("IMPRESSORA_3D"),
  
  OUTRO("OUTRO");

  private String value;

  CategoriaEquipamento(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CategoriaEquipamento fromValue(String value) {
    for (CategoriaEquipamento b : CategoriaEquipamento.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

