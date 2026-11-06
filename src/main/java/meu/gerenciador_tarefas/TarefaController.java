package meu.gerenciador_tarefas;

import jakarta.validation.Valid;
import meu.gerenciador_tarefas.dtos.TarefaRequest;
import meu.gerenciador_tarefas.dtos.TarefaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponse> criar(@Valid @RequestBody TarefaRequest request) {
        TarefaResponse response = tarefaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponse> buscar(@PathVariable Long id) {
        return tarefaService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public List<TarefaResponse> buscarTodos() {
        return tarefaService.buscarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponse> atualizar(@Valid @RequestBody TarefaRequest atualizada, @PathVariable Long id) {
        return tarefaService.atualizar(atualizada, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if(tarefaService.deletar(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}