package com.futurize.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_fz_curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;

    @NotBlank(message = "O nome do curso é obrigatório")
    @Size(max = 120, message = "O nome deve ter no máximo 120 caracteres")
    @Column(name = "nm_curso", nullable = false, length = 120)
    private String nome;

    @NotBlank(message = "A categoria é obrigatória")
    @Size(max = 60, message = "A categoria deve ter no máximo 60 caracteres")
    @Column(name = "ds_categoria", nullable = false, length = 60)
    private String categoria;

    @NotNull(message = "A carga horária é obrigatória")
    @Positive(message = "A carga horária deve ser positiva")
    @Column(name = "qt_carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @NotBlank(message = "O nível é obrigatório")
    @Size(max = 20, message = "O nível deve ter no máximo 20 caracteres")
    @Column(name = "ds_nivel", nullable = false, length = 20)
    private String nivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
