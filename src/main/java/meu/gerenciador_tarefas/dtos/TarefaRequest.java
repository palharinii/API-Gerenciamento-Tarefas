package meu.gerenciador_tarefas.dtos;

import meu.gerenciador_tarefas.Prioridade;
import meu.gerenciador_tarefas.Status;

import java.time.LocalDate;

public record TarefaRequest(
        String nome,
        String descricao,
        Status status,
        Prioridade prioridade,
        LocalDate dataCriacao,
        LocalDate prazoEntrega
) {}