-- Inserir Usuários
INSERT INTO t_fz_usuario (id_usuario, nm_usuario, ds_email, st_ativo, dt_cadastro)
VALUES (sq_fz_usuario.NEXTVAL, 'Ana Silva', 'ana.silva@futurize.com', 'S', SYSDATE);

INSERT INTO t_fz_usuario (id_usuario, nm_usuario, ds_email, st_ativo, dt_cadastro)
VALUES (sq_fz_usuario.NEXTVAL, 'Bruno Costa', 'bruno.costa@futurize.com', 'S', SYSDATE);

-- Inserir Cursos
INSERT INTO t_fz_curso (id_curso, nm_curso, ds_curso)
VALUES (sq_fz_curso.NEXTVAL, 'Java Advanced', 'Curso avançado de Java com foco em Quarkus.');

INSERT INTO t_fz_curso (id_curso, nm_curso, ds_curso)
VALUES (sq_fz_curso.NEXTVAL, 'Frontend React', 'Desenvolvimento de interfaces com React e Redux.');

-- Inserir Habilidades
INSERT INTO t_fz_habilidade (id_habilidade, nm_habilidade, ds_habilidade)
VALUES (sq_fz_habilidade.NEXTVAL, 'JPA Hibernate', 'Mapeamento Objeto-Relacional.');

INSERT INTO t_fz_habilidade (id_habilidade, nm_habilidade, ds_habilidade)
VALUES (sq_fz_habilidade.NEXTVAL, 'RESTful API', 'Criação de APIs REST.');

-- Inserir UsuarioHabilidade (Ana tem JPA e REST)
INSERT INTO t_fz_usuario_habilidade (id_usuario_habilidade, id_usuario, id_habilidade, nr_nivel)
VALUES (sq_fz_usuario_habilidade.NEXTVAL, 1, 1, 5);

INSERT INTO t_fz_usuario_habilidade (id_usuario_habilidade, id_usuario, id_habilidade, nr_nivel)
VALUES (sq_fz_usuario_habilidade.NEXTVAL, 1, 2, 4);

-- Inserir Recomendacoes (Ana tem recomendação para Java Advanced e React)
INSERT INTO t_fz_recomendacao (id_recomendacao, id_usuario, id_curso, nr_prioridade)
VALUES (sq_fz_recomendacao.NEXTVAL, 1, 1, 8);

INSERT INTO t_fz_recomendacao (id_recomendacao, id_usuario, id_curso, nr_prioridade)
VALUES (sq_fz_recomendacao.NEXTVAL, 1, 2, 5);

COMMIT;
