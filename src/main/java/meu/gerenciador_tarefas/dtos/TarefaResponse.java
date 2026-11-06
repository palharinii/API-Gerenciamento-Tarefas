package meu.gerenciador_tarefas.dtos;

import meu.gerenciador_tarefas.Prioridade;
import meu.gerenciador_tarefas.Status;
import meu.gerenciador_tarefas.Tarefa;

import java.time.LocalDate;

public record TarefaResponse(
        Long id,
        String nome,
        String descricao,
        Status status,
        Prioridade prioridade,
        LocalDate dataCriacao,
        LocalDate prazoEntrega
) {
    public TarefaResponse(Tarefa tarefa) {
        this(
                tarefa.getId(),
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getPrioridade(),
                tarefa.getDataCriacao(),
                tarefa.getPrazoEntrega()
        );
    }
}