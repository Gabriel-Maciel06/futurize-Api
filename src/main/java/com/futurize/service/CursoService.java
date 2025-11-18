package com.futurize.service;

import com.futurize.api.exception.NotFoundException;
import com.futurize.domain.Curso;
import com.futurize.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CursoService {
    @Inject
    CursoRepository repository;

    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Curso findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Curso não encontrado com ID: " + id));
    }

    @Transactional
    public Curso create(Curso curso) {
        return repository.save(curso);
    }

    @Transactional
    public Curso update(Long id, Curso curso) {
        Curso existing = findById(id);
        
        existing.setNome(curso.getNome());
        existing.setDescricao(curso.getDescricao());
        
        return repository.update(existing);
    }

    @Transactional
    public void delete(Long id) {
        Curso curso = findById(id);
        repository.delete(curso);
    }
}
