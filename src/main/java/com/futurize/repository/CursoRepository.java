package com.futurize.repository;

import com.futurize.domain.Curso;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CursoRepository extends BaseRepository<Curso, Long> {
    @Override
    protected Class<Curso> getEntityClass() {
        return Curso.class;
    }
}
