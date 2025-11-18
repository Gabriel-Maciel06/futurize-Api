package com.futurize.service;

import com.futurize.api.exception.NotFoundException;
import com.futurize.domain.UsuarioHabilidade;
import com.futurize.repository.UsuarioHabilidadeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UsuarioHabilidadeService {
    @Inject
    UsuarioHabilidadeRepository repository;
    
    @Inject
    UsuarioService usuarioService;
    
    @Inject
    HabilidadeService habilidadeService;

    public List<UsuarioHabilidade> findAll() {
        return repository.findAll();
    }

    public UsuarioHabilidade findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Registro de Habilidade do Usuário não encontrado com ID: " + id));
    }
    
    public List<UsuarioHabilidade> findByUsuarioId(Long usuarioId) {
        usuarioService.findById(usuarioId);
        return repository.findByUsuarioId(usuarioId);
    }

    @Transactional
    public UsuarioHabilidade create(UsuarioHabilidade usuarioHabilidade) {
        usuarioHabilidade.setUsuario(usuarioService.findById(usuarioHabilidade.getUsuario().getId()));
        usuarioHabilidade.setHabilidade(habilidadeService.findById(usuarioHabilidade.getHabilidade().getId()));
        return repository.save(usuarioHabilidade);
    }

    @Transactional
    public UsuarioHabilidade update(Long id, UsuarioHabilidade usuarioHabilidade) {
        UsuarioHabilidade existing = findById(id);
        
        existing.setUsuario(usuarioService.findById(usuarioHabilidade.getUsuario().getId()));
        existing.setHabilidade(habilidadeService.findById(usuarioHabilidade.getHabilidade().getId()));
        existing.setNivel(usuarioHabilidade.getNivel());
        
        return repository.update(existing);
    }

    @Transactional
    public void delete(Long id) {
        UsuarioHabilidade usuarioHabilidade = findById(id);
        repository.delete(usuarioHabilidade);
    }
}
