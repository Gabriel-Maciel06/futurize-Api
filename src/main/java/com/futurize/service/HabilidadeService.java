package com.futurize.service;

import com.futurize.api.exception.NotFoundException;
import com.futurize.domain.Habilidade;
import com.futurize.repository.HabilidadeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class HabilidadeService {
    @Inject
    HabilidadeRepository repository;

    public List<Habilidade> findAll() {
        return repository.findAll();
    }

    public Habilidade findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Habilidade não encontrada com ID: " + id));
    }

    @Transactional
    public Habilidade create(Habilidade habilidade) {
        return repository.save(habilidade);
    }

    @Transactional
    public Habilidade update(Long id, Habilidade habilidade) {
        Habilidade existing = findById(id);
        
        existing.setNome(habilidade.getNome());
        existing.setDescricao(habilidade.getDescricao());
        
        return repository.update(existing);
    }

    @Transactional
    public void delete(Long id) {
        Habilidade habilidade = findById(id);
        repository.delete(habilidade);
    }
}
