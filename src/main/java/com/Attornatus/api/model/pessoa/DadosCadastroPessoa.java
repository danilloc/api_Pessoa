package com.Attornatus.api.model.pessoa;

import com.Attornatus.api.model.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCadastroPessoa(
        @NotBlank
        String nome,
        @NotBlank
        String dataNasc,
        @NotNull @Valid
        List<DadosEndereco> enderecos ) {
}
