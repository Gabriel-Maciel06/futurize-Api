package com.futurize.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_fz_habilidade")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidade")
    private Long id;

    @NotBlank(message = "O nome da habilidade é obrigatório")
    @Size(max = 80, message = "O nome deve ter no máximo 80 caracteres")
    @Column(name = "nm_habilidade", nullable = false, length = 80)
    private String nome;

    @NotBlank(message = "A categoria é obrigatória")
    @Size(max = 60, message = "A categoria deve ter no máximo 60 caracteres")
    @Column(name = "ds_categoria", nullable = false, length = 60)
    private String categoria;

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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
