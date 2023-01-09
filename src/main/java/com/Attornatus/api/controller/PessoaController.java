package com.Attornatus.api.controller;

import com.Attornatus.api.model.endereco.DadosEndereco;
import com.Attornatus.api.model.endereco.Endereco;
import com.Attornatus.api.mapper.EnderecoMapper;
import com.Attornatus.api.model.pessoa.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private IPessoaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPessoa(@RequestBody @Valid DadosCadastroPessoa dados){
        repository.save(new Pessoa(dados));

    }

    @PutMapping
    @Transactional
    public void atualizarPessoa(@RequestBody @Valid DadosAtualizacaoPessoa dados){
        var pessoa = repository.getReferenceById(dados.id());
        pessoa.atualizarInformacoes(dados);
    }

    @GetMapping
    public Page<DadosListagemPessoa> listarPessoas(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPessoa::new);
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> listarPessoaById(@PathVariable Long id){

        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirPessoa (@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/{idPessoa}/enderecos")
    public List<Endereco> listarEnderecos(@PathVariable Long idPessoa){

        return repository.findById(idPessoa).get().getEnderecos();
    }

    @PostMapping("/{idPessoa}/endereco")
    @Transactional
    public void cadastrarEndereco(@RequestBody @Valid DadosEndereco dadosEndereco,
                                  @PathVariable Long idPessoa){

        Pessoa pessoa = repository.findById(idPessoa).get();
        pessoa.getEnderecos().add(EnderecoMapper.convertToEndereco(dadosEndereco));
        repository.save(pessoa);

    }
    @PatchMapping("/{idPessoa}/endereco/{idEndereco}/principal")
    public void definirEnderecoPrincipal(@PathVariable Long idPessoa, @PathVariable Long idEndereco){
        Pessoa pessoa = repository.findById(idPessoa).get();
        for (Endereco endereco : pessoa.getEnderecos()){
            endereco.setPrincipal(false);
            if (idEndereco.equals(endereco.getId())){
                endereco.setPrincipal(true);
            }
        }
        repository.save(pessoa);
    }
}
