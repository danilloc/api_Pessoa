package com.Attornatus.api.model.pessoa;

import com.Attornatus.api.model.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
        @NotNull
        Long id,
        String nome,
        String dataNasc,
        DadosEndereco endereco ) {

}
