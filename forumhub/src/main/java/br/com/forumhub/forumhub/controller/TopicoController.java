package br.com.forumhub.forumhub.controller;

import br.com.forumhub.forumhub.topico.DadosCadastroTopico;
import br.com.forumhub.forumhub.topico.Topico;
import br.com.forumhub.forumhub.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroTopico dadosCadastroTopico){
        topicoRepository.save(new Topico(dadosCadastroTopico));
    }
}
