package com.futurize.service;

import com.futurize.api.exception.NotFoundException;
import com.futurize.api.exception.ValidationException;
import com.futurize.domain.Usuario;
import com.futurize.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UsuarioService {
    @Inject
    UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado com ID: " + id));
    }

    @Transactional
    public Usuario create(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ValidationException("E-mail já cadastrado: " + usuario.getEmail());
        }
        return repository.save(usuario);
    }

    @Transactional
    public Usuario update(Long id, Usuario usuario) {
        Usuario existing = findById(id);
        
        if (!existing.getEmail().equals(usuario.getEmail()) && repository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ValidationException("E-mail já cadastrado: " + usuario.getEmail());
        }

        existing.setNome(usuario.getNome());
        existing.setEmail(usuario.getEmail());
        existing.setAtivo(usuario.getAtivo());
        
        return repository.update(existing);
    }

    @Transactional
    public void delete(Long id) {
        Usuario usuario = findById(id);
        repository.delete(usuario);
    }
}
