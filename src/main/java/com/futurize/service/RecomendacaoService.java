package com.futurize.service;

import com.futurize.api.exception.NotFoundException;
import com.futurize.domain.Recomendacao;
import com.futurize.repository.RecomendacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RecomendacaoService {
    @Inject
    RecomendacaoRepository repository;
    
    @Inject
    UsuarioService usuarioService;
    
    @Inject
    CursoService cursoService;

    public List<Recomendacao> findAll() {
        return repository.findAll();
    }

    public Recomendacao findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recomendação não encontrada com ID: " + id));
    }
    
    public List<Recomendacao> findByUsuarioId(Long usuarioId) {
        usuarioService.findById(usuarioId);
        return repository.findByUsuarioId(usuarioId);
    }

    @Transactional
    public Recomendacao create(Recomendacao recomendacao) {
        recomendacao.setUsuario(usuarioService.findById(recomendacao.getUsuario().getId()));
        recomendacao.setCurso(cursoService.findById(recomendacao.getCurso().getId()));
        return repository.save(recomendacao);
    }

    @Transactional
    public Recomendacao update(Long id, Recomendacao recomendacao) {
        Recomendacao existing = findById(id);
        
        existing.setUsuario(usuarioService.findById(recomendacao.getUsuario().getId()));
        existing.setCurso(cursoService.findById(recomendacao.getCurso().getId()));
        existing.setPrioridade(recomendacao.getPrioridade());
        
        return repository.update(existing);
    }

    @Transactional
    public void delete(Long id) {
        Recomendacao recomendacao = findById(id);
        repository.delete(recomendacao);
    }
}
