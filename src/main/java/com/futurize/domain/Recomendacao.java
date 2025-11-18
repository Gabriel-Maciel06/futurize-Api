package com.futurize.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "t_fz_recomendacao")
public class Recomendacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recomendacao_seq")
    @SequenceGenerator(name = "recomendacao_seq", sequenceName = "sq_fz_recomendacao", allocationSize = 1)
    @Column(name = "id_recomendacao")
    private Long id;

    @NotNull(message = "O usuário é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "O curso é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @NotNull(message = "A prioridade é obrigatória")
    @PositiveOrZero(message = "A prioridade deve ser positiva ou zero")
    @Max(value = 10, message = "A prioridade máxima é 10")
    @Column(name = "nr_prioridade", nullable = false)
    private Integer prioridade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
}
