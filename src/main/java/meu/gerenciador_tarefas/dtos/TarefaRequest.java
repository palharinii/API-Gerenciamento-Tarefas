package meu.gerenciador_tarefas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import meu.gerenciador_tarefas.Prioridade;
import meu.gerenciador_tarefas.Status;

import java.time.LocalDate;

public record TarefaRequest(
        @NotBlank String nome,
        String descricao,
        Status status,
        Prioridade prioridade,
        LocalDate dataCriacao,
        @NotNull LocalDate prazoEntrega
) {}