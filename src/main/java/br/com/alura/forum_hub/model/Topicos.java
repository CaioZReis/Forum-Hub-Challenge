package br.com.alura.forum_hub.model;

import br.com.alura.forum_hub.dto.DadosAtualizacaoTopicos;
import br.com.alura.forum_hub.dto.DadosCadastroTopicos;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private boolean estado;
    private String autor;
    private String curso;


    public Topicos() {

    }
    public Topicos(DadosCadastroTopicos topico) {
        LocalDateTime dataAtual = LocalDateTime.now();
        this.titulo = topico.titulo();
        this.mensagem = topico.mensagem();
        this.dataCriacao = dataAtual;
        this.estado = true;
        this.autor = topico.autor();
        this.curso = topico.curso();
    }

    public String getCurso() {
        return curso;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEstado() {
        return estado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public void alterarTopico(DadosAtualizacaoTopicos topico){
        if (topico.titulo() != null){
            this.titulo = topico.titulo();
        }
        if (topico.mensagem() != null){
            this.mensagem = topico.mensagem();
        }
        if (topico.autor() != null){
            this.autor = topico.autor();
        }
        if (topico.curso() != null){
            this.curso = topico.curso();
        }
    }

    public void excluirTopico(){
        this.estado = false;
    }
}