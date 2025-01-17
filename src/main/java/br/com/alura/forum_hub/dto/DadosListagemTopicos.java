package br.com.alura.forum_hub.dto;

import br.com.alura.forum_hub.model.Topicos;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        //Lembrar de retirar o id do corpo do Json
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        boolean estado,
        String autor,
        String curso) {

    public DadosListagemTopicos(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getDataCriacao(), topicos.isEstado(), topicos.getAutor(), topicos.getCurso());
    }
}
