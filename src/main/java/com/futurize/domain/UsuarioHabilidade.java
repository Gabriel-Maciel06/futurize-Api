package com.futurize.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "t_fz_usuario_habilidade")
public class UsuarioHabilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_habilidade_seq")
    @SequenceGenerator(name = "usuario_habilidade_seq", sequenceName = "sq_fz_usuario_habilidade", allocationSize = 1)
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

    @NotNull(message = "O nível de proficiência é obrigatório")
    @PositiveOrZero(message = "O nível deve ser positivo ou zero")
    @Max(value = 5, message = "O nível máximo é 5")
    @Column(name = "nr_nivel", nullable = false)
    private Integer nivel;

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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
