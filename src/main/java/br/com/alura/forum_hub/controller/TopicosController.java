package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.dto.DadosAtualizacaoTopicos;
import br.com.alura.forum_hub.dto.DadosCadastroTopicos;
import br.com.alura.forum_hub.dto.DadosListagemTopicos;
import br.com.alura.forum_hub.model.Topicos;
import br.com.alura.forum_hub.repository.RepositorioTopicos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class TopicosController {

    @Autowired
    private RepositorioTopicos repositorioTopicos;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarTopico(@RequestBody @Valid DadosCadastroTopicos topico){
        if (repositorioTopicos.existsByTituloAndMensagem(topico.titulo(), topico.mensagem())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um tópico com o mesmo título e mensagem.");
        }
        repositorioTopicos.save(new Topicos(topico));

        return ResponseEntity.ok("Tópico criado com sucesso.");
    }

    @GetMapping
    public Page<DadosListagemTopicos> verTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        return repositorioTopicos.findAll(paginacao).map(DadosListagemTopicos::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopicos> verTopicosPorId(@PathVariable Long id) {
        return repositorioTopicos.findById(id)
                .map(topicos -> ResponseEntity
                        .ok(new DadosListagemTopicos(topicos)))
                .orElse(ResponseEntity
                        .notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> atualizarTopico(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopicos topico){
        if (!repositorioTopicos.existsById(id))  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico com ID " + id + " não encontrado.");
        }
        if (repositorioTopicos.existsByTituloAndMensagem(topico.titulo(), topico.mensagem())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um tópico com o mesmo título e mensagem.");
        }
        var alterar = repositorioTopicos.getReferenceById(id);
        alterar.alterarTopico(topico);
        return ResponseEntity.ok("Tópico atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> excluirTopico(@PathVariable Long id){
        if (!repositorioTopicos.existsById(id))  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico com ID " + id + " não encontrado.");
        }
        repositorioTopicos.deleteById(id);
        return ResponseEntity.ok("Tópico deletado com sucesso.");
    }
}