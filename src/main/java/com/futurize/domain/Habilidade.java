package com.futurize.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_fz_habilidade")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habilidade_seq")
    @SequenceGenerator(name = "habilidade_seq", sequenceName = "sq_fz_habilidade", allocationSize = 1)
    @Column(name = "id_habilidade")
    private Long id;

    @NotBlank(message = "O nome da habilidade é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(name = "nm_habilidade", nullable = false, length = 100)
    private String nome;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    @Column(name = "ds_habilidade", length = 255)
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
