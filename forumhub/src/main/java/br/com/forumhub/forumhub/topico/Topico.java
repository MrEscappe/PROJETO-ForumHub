package br.com.forumhub.forumhub.topico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String autor;
    private String curso;

    public Topico(DadosCadastroTopico dadosCadastroTopico) {
        this.titulo = dadosCadastroTopico.titulo();
        this.mensagem = dadosCadastroTopico.mensagem();
        this.autor = dadosCadastroTopico.autor();
        this.curso = dadosCadastroTopico.curso();
    }
}
