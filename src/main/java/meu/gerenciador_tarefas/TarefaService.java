package meu.gerenciador_tarefas;

import meu.gerenciador_tarefas.dtos.TarefaRequest;
import meu.gerenciador_tarefas.dtos.TarefaResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaResponse criar(TarefaRequest request) {
        Tarefa tarefa = new Tarefa(
                request.nome(),
                request.descricao(),
                request.prazoEntrega()
        );

        tarefaRepository.save(tarefa);

        return new TarefaResponse(tarefa);
    }

    public Optional<TarefaResponse> buscar(Long id) {
        return tarefaRepository.findById(id).map(TarefaResponse::new);
    }

    public List<TarefaResponse> buscarTodos() {
        return tarefaRepository.findAll()
                .stream()
                .map(TarefaResponse::new)
                .toList();
    }

    public Optional<TarefaResponse> atualizar(TarefaRequest atualizada, Long id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);

        if(optional.isEmpty()) {
            return Optional.empty();
        }

        Tarefa tarefa = optional.get();

        tarefa.setNome(atualizada.nome());
        tarefa.setDescricao(atualizada.descricao());
        tarefa.setStatus(atualizada.status());
        tarefa.setPrioridade(atualizada.prioridade());
        tarefa.setPrazoEntrega(atualizada.prazoEntrega());

        tarefaRepository.save(tarefa);

        return optional.map(TarefaResponse::new);
    }

    public boolean deletar(Long id) {
        if(!tarefaRepository.existsById(id)) {
            return false;
        }

        tarefaRepository.deleteById(id);
        return true;
    }
}