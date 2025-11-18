package com.futurize.repository;

import com.futurize.domain.Recomendacao;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RecomendacaoRepository extends BaseRepository<Recomendacao, Long> {
    @Override
    protected Class<Recomendacao> getEntityClass() {
        return Recomendacao.class;
    }

    public List<Recomendacao> findByUsuarioId(Long usuarioId) {
        return entityManager.createQuery(
                "SELECT r FROM Recomendacao r WHERE r.usuario.id = :usuarioId ORDER BY r.prioridade DESC", Recomendacao.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }
}
