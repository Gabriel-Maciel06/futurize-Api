package com.futurize.repository;

import com.futurize.domain.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

@ApplicationScoped
public class UsuarioRepository extends BaseRepository<Usuario, Long> {
    @Override
    protected Class<Usuario> getEntityClass() {
        return Usuario.class;
    }

    public Optional<Usuario> findByEmail(String email) {
        try {
            TypedQuery<Usuario> query = entityManager.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
            query.setParameter("email", email);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
