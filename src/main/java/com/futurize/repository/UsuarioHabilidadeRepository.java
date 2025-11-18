package com.futurize.repository;

import com.futurize.domain.UsuarioHabilidade;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UsuarioHabilidadeRepository extends BaseRepository<UsuarioHabilidade, Long> {
    @Override
    protected Class<UsuarioHabilidade> getEntityClass() {
        return UsuarioHabilidade.class;
    }

    public List<UsuarioHabilidade> findByUsuarioId(Long usuarioId) {
        return entityManager.createQuery(
                "SELECT uh FROM UsuarioHabilidade uh WHERE uh.usuario.id = :usuarioId", UsuarioHabilidade.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }
}
