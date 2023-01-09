package com.Attornatus.api.mapper;

import com.Attornatus.api.model.endereco.DadosEndereco;
import com.Attornatus.api.model.endereco.Endereco;

import java.util.ArrayList;
import java.util.List;

public class EnderecoMapper {



    public static List<Endereco> convertToListEndereco(List<DadosEndereco> dadosEnderecoEntrada){
        List<Endereco> enderecos = new ArrayList<>();

        for(DadosEndereco dadosEndereco :dadosEnderecoEntrada){
            enderecos.add(Endereco.builder()
                    .logradouro(dadosEndereco.logradouro())
                    .cep(dadosEndereco.cep())
                    .numero(dadosEndereco.numero())
                    .cidade(dadosEndereco.cidade())
                    .build());

        }
        return enderecos;
    }

    public static Endereco convertToEndereco(DadosEndereco dadosEndereco){
        return Endereco.builder()
                .logradouro(dadosEndereco.logradouro())
                .cep(dadosEndereco.cep())
                .numero(dadosEndereco.numero())
                .cidade(dadosEndereco.cidade())
                .build();
    }
}
