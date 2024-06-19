package br.com.forumhub.forumhub.controller;

import br.com.forumhub.forumhub.topico.*;
import jakarta.validation.Valid;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dadosCadastroTopico){
        topicoRepository.save(new Topico(dadosCadastroTopico));

    }

    @GetMapping
    public Page<DadosListagemTopico> listar(
            @PageableDefault(size = 10, sort = "dataCriacao", direction = Sort.Direction.ASC)
            Pageable pageable){
        return topicoRepository.findAll(pageable)
                .map(DadosListagemTopico::new);
    }

    @GetMapping("/{id}")
    public Topico detalhar(@PathVariable Long id){
        return topicoRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarTopico dadosAtualizarTopico){
        var topico = topicoRepository.getReferenceById(dadosAtualizarTopico.id());
        topico.atualizar(dadosAtualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        topicoRepository.deleteById(id);
    }
}
