package com.repairsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PecaRequestDTO(
    @NotBlank(message = "Nome da peça é obrigatório")
    @Size(min = 3, max = 200, message = "Nome deve ter entre 3 e 200 caracteres")
    String nome,

    @NotBlank(message = "Part Number é obrigatório")
    @Size(min = 3, max = 50, message = "Part Number deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Z0-9\\-]+$", message = "Part Number deve conter apenas letras maiúsculas, números e hífen")
    String partNumber,

    @Size(max = 100, message = "Categoria deve ter no máximo 100 caracteres")
    String categoria
) {}
