package com.futurize.repository;

import com.futurize.domain.Habilidade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HabilidadeRepository extends BaseRepository<Habilidade, Long> {
    @Override
    protected Class<Habilidade> getEntityClass() {
        return Habilidade.class;
    }
}
