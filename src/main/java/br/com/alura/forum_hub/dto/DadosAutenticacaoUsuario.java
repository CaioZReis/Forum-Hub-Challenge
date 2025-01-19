package br.com.alura.forum_hub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacaoUsuario(@NotBlank String login, @NotBlank String senha) {
}
