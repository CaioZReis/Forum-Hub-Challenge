package br.com.alura.forum_hub.dto;

import br.com.alura.forum_hub.model.Topicos;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record DadosListagemTopicos(

        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        boolean estado,
        String autor,
        String curso
){
    public DadosListagemTopicos(Topicos topicos){
        this(topicos.getTitulo(), topicos.getMensagem(), topicos.getDataCriacao(), topicos.isEstado(), topicos.getAutor(), topicos.getCurso());
    }
}
