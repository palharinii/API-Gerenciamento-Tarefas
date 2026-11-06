package meu.gerenciador_tarefas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@Getter @Setter
public class Tarefa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING) private Status status = Status.PENDENTE;
    @Enumerated(EnumType.STRING) private Prioridade prioridade = Prioridade.BAIXA;
    private final LocalDate dataCriacao = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
    private LocalDate prazoEntrega;

    public Tarefa() {}

    public Tarefa(String nome, String descricao, LocalDate prazoEntrega) {
        this.nome = nome;
        this.descricao = descricao;
        this.prazoEntrega = prazoEntrega;
    }
}