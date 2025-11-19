package com.futurize.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "t_fz_recomendacao")
public class Recomendacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "dt_recomendacao", nullable = false)
    private LocalDate dataRecomendacao;

    @NotNull(message = "A prioridade é obrigatória")
    @Min(value = 1, message = "A prioridade mínima é 1")
    @Max(value = 5, message = "A prioridade máxima é 5")
    @Column(name = "nu_prioridade", nullable = false)
    private Integer prioridade;

    @Size(max = 200, message = "O motivo deve ter no máximo 200 caracteres")
    @Column(name = "ds_motivo", length = 200)
    private String motivo;

    @PrePersist
    public void prePersist() {
        if (dataRecomendacao == null) {
            dataRecomendacao = LocalDate.now();
        }
        if (prioridade == null) {
            prioridade = 3;
        }
    }

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

    public LocalDate getDataRecomendacao() {
        return dataRecomendacao;
    }

    public void setDataRecomendacao(LocalDate dataRecomendacao) {
        this.dataRecomendacao = dataRecomendacao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
