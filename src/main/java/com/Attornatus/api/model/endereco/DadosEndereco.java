package com.Attornatus.api.model.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotNull
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String numero,
        @NotBlank
        String cidade) {
}
