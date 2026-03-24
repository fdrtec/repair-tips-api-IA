package com.repairsystem.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.repairsystem.dto.PecaResponseDTO;
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
 * PagePecaResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-23T22:40:45.938316944-03:00[America/Sao_Paulo]", comments = "Generator version: 7.8.0")
public class PagePecaResponseDTO {

  @Valid
  private List<@Valid PecaResponseDTO> content = new ArrayList<>();

  private Optional<Long> totalElements = Optional.empty();

  private Optional<Integer> totalPages = Optional.empty();

  private Optional<Integer> currentPage = Optional.empty();

  public PagePecaResponseDTO content(List<@Valid PecaResponseDTO> content) {
    this.content = content;
    return this;
  }

  public PagePecaResponseDTO addContentItem(PecaResponseDTO contentItem) {
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
  public List<@Valid PecaResponseDTO> getContent() {
    return content;
  }

  public void setContent(List<@Valid PecaResponseDTO> content) {
    this.content = content;
  }

  public PagePecaResponseDTO totalElements(Long totalElements) {
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

  public PagePecaResponseDTO totalPages(Integer totalPages) {
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

  public PagePecaResponseDTO currentPage(Integer currentPage) {
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
    PagePecaResponseDTO pagePecaResponseDTO = (PagePecaResponseDTO) o;
    return Objects.equals(this.content, pagePecaResponseDTO.content) &&
        Objects.equals(this.totalElements, pagePecaResponseDTO.totalElements) &&
        Objects.equals(this.totalPages, pagePecaResponseDTO.totalPages) &&
        Objects.equals(this.currentPage, pagePecaResponseDTO.currentPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, totalElements, totalPages, currentPage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagePecaResponseDTO {\n");
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

