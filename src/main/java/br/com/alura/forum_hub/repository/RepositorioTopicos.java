package br.com.alura.forum_hub.repository;

import br.com.alura.forum_hub.model.Topicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTopicos extends JpaRepository<Topicos, Long> {
    boolean existsByTituloAndMensagem(String topicoTitulo, String topicoMensagem);
}