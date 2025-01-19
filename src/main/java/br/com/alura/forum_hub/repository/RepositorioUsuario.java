package br.com.alura.forum_hub.repository;

import br.com.alura.forum_hub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
