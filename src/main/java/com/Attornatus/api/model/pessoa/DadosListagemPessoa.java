package com.Attornatus.api.model.pessoa;

import com.Attornatus.api.model.endereco.Endereco;

import java.util.List;

public record DadosListagemPessoa(Long id, String nome, String dataNasc, List<Endereco> enderecos) {

    public DadosListagemPessoa(Pessoa pessoa){

        this(pessoa.getId(), pessoa.getNome(), pessoa.getDataNasc(), pessoa.getEnderecos());
    }


}
