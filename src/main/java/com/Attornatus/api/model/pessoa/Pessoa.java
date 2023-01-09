package com.Attornatus.api.model.pessoa;


import com.Attornatus.api.model.endereco.Endereco;
import com.Attornatus.api.mapper.EnderecoMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String dataNasc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa")
    private List<Endereco> enderecos;

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.dataNasc = dados.dataNasc();
        this.enderecos = EnderecoMapper.convertToListEndereco(dados.enderecos());
    }


    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
        if (dados.nome()!= null){
            this.nome = dados.nome();
        }
        if (dados.dataNasc()!= null){
            this.dataNasc = dados.dataNasc();
        }
//        if (dados.endereco()!= null){
//            this.enderecos.atualizarInformacoe(dados.endereco());
//        }

    }




}

