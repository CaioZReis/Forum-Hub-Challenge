package br.com.alura.forum_hub.repository;

import br.com.alura.forum_hub.model.Topicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioTopicos extends JpaRepository<Topicos, Long> {
    Page<Topicos> findByEstadoTrue(Pageable pageable);

    boolean existsByTituloAndMensagem(String topicoTitulo, String topicoMensagem);
}