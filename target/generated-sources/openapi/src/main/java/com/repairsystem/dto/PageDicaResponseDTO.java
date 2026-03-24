package com.repairsystem.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.repairsystem.dto.DicaResponseDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PageDicaResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:52:47.635407812-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class PageDicaResponseDTO {

  @Valid
  private List<@Valid DicaResponseDTO> content = new ArrayList<>();

  private Optional<Long> totalElements = Optional.empty();

  private Optional<Integer> totalPages = Optional.empty();

  private Optional<Integer> currentPage = Optional.empty();

  public PageDicaResponseDTO content(List<@Valid DicaResponseDTO> content) {
    this.content = content;
    return this;
  }

  public PageDicaResponseDTO addContentItem(DicaResponseDTO contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<>();
    }
    this.content.add(contentItem);
    return this;
  }

  /**
   * Get content
   * @return content
   */
  @Valid 
  @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("content")
  public List<@Valid DicaResponseDTO> getContent() {
    return content;
  }

  public void setContent(List<@Valid DicaResponseDTO> content) {
    this.content = content;
  }

  public PageDicaResponseDTO totalElements(Long totalElements) {
    this.totalElements = Optional.of(totalElements);
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
   */
  
  @Schema(name = "totalElements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalElements")
  public Optional<Long> getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Optional<Long> totalElements) {
    this.totalElements = totalElements;
  }

  public PageDicaResponseDTO totalPages(Integer totalPages) {
    this.totalPages = Optional.of(totalPages);
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
   */
  
  @Schema(name = "totalPages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPages")
  public Optional<Integer> getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Optional<Integer> totalPages) {
    this.totalPages = totalPages;
  }

  public PageDicaResponseDTO currentPage(Integer currentPage) {
    this.currentPage = Optional.of(currentPage);
    return this;
  }

  /**
   * Get currentPage
   * @return currentPage
   */
  
  @Schema(name = "currentPage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentPage")
  public Optional<Integer> getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Optional<Integer> currentPage) {
    this.currentPage = currentPage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageDicaResponseDTO pageDicaResponseDTO = (PageDicaResponseDTO) o;
    return Objects.equals(this.content, pageDicaResponseDTO.content) &&
        Objects.equals(this.totalElements, pageDicaResponseDTO.totalElements) &&
        Objects.equals(this.totalPages, pageDicaResponseDTO.totalPages) &&
        Objects.equals(this.currentPage, pageDicaResponseDTO.currentPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, totalPages, currentPage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageDicaResponseDTO {\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
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

