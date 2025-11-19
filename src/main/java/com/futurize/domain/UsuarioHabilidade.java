package com.futurize.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import java.time.LocalDate;

@Entity
@Table(name = "t_fz_usuario_habilidade")
public class UsuarioHabilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_habilidade")
    private Long id;

    @NotNull(message = "O usuário é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "A habilidade é obrigatória")
    @ManyToOne
    @JoinColumn(name = "id_habilidade", nullable = false)
    private Habilidade habilidade;

    @NotNull(message = "A proficiência é obrigatória")
    @Min(value = 0, message = "A proficiência mínima é 0")
    @Max(value = 100, message = "A proficiência máxima é 100")
    @Column(name = "nu_proficiencia", nullable = false)
    private Integer proficiencia;

    @Column(name = "dt_atualizacao", nullable = false)
    private LocalDate dataAtualizacao;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (dataAtualizacao == null) {
            dataAtualizacao = LocalDate.now();
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

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    public Integer getProficiencia() {
        return proficiencia;
    }

    public void setProficiencia(Integer proficiencia) {
        this.proficiencia = proficiencia;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
