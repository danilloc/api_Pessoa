package com.Attornatus.api.model.endereco;

import com.Attornatus.api.model.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String logradouro;
    @Column
    private String cep;
    @Column
    private String numero;
    @Column
    private String cidade;

    @ManyToOne
    private Pessoa pessoa;

    @Column(name = "principal")
    private boolean isPrincipal;




    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
    }


    public void atualizarInformacoe(DadosEndereco dados) {
        if (dados.logradouro() != null){
            this.logradouro = logradouro;
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
        if (dados.numero() != null){
            this.numero = dados.numero();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
    }


}
