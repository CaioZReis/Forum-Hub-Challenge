package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.DadosAutenticacaoUsuario;
import br.com.alura.forum_hub.dto.DadosTokenJWT;
import br.com.alura.forum_hub.model.Usuario;
import br.com.alura.forum_hub.seguranca.ServicoToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private ServicoToken servicoToken;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoUsuario usuario){
        var token = new UsernamePasswordAuthenticationToken(usuario.login(), usuario.senha());
        var autenticacao = manager.authenticate(token);

        var tokenJWT = servicoToken.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
