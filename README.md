# API Futurize - Domain Driven Design Using Java (Quarkus)

## Informações do Projeto

**Disciplina:** Domain Driven Design Using Java (Quarkus)  
**Curso:** FIAP  
**Versão:** 1.0.0

### Integrantes

| Nome | RM |
|---|---|
| Gabriel Maciel Alves de Oliveira | 562795 |
| Thomas Mineu Fontes | 562254 |
| Matheus Pereira Molina | 563399 |

## Descrição da Solução

API RESTful desenvolvida em **Quarkus** para o projeto **Futurize**, com o objetivo de gerenciar usuários, cursos, habilidades e recomendações. A aplicação utiliza **JPA/Hibernate** para persistência de dados no banco **Oracle**, seguindo a arquitetura em camadas **Model/Repository/Service/Resource** (DDD/MVC).

### O que foi implementado

- **5 Entidades JPA** (`Usuario`, `Curso`, `Habilidade`, `UsuarioHabilidade`, `Recomendacao`) com mapeamento correto e `Bean Validation`.
- **5 Repositories** (DAO) com `EntityManager` injetado e métodos CRUD.
- **5 Services** (BO) com regras de negócio, injeção de dependência e controle transacional (`@Transactional`).
- **5 Resources** (REST) com endpoints corretos, tratamento de exceções e status HTTP adequados (201, 204, 404).
- **Tratamento de Exceções** centralizado via `ExceptionMapper` para `NotFoundException` (404) e `ValidationException` (400).
- **Configuração CORS** habilitada para integração com o frontend.
- **OpenAPI/Swagger** configurado para documentação automática.



## Destaques Implementados

- **Arquitetura Limpa:** Separação clara de responsabilidades entre as camadas Model, Repository, Service e Resource.
- **Validação de Negócio:** Implementação de regras como e-mail único (`UsuarioService`) e validação de relacionamentos.
- **Boas Práticas REST:** Uso de `Response.created(uri)` com status 201 e `Location` no POST, e `Response.noContent()` com status 204 no DELETE.
- **Tratamento de Erros:** Mapeamento de exceções para respostas HTTP corretas, garantindo robustez da API.

## Configuração

### Arquivo `application.properties`

O arquivo de configuração está em `src/main/resources/application.properties`. **É necessário ajustar as credenciais do Oracle.**

```properties
# Configurações do Banco de Dados Oracle
quarkus.datasource.db-kind=oracle
quarkus.datasource.username=FUTURIZE
quarkus.datasource.password=FUTURIZE_PWD
quarkus.datasource.jdbc.url=jdbc:oracle:thin:@//HOST:1521/SERVICE
```

### Scripts SQL

O script `database/create_tables.sql` deve ser executado no seu banco de dados Oracle para criar as tabelas e sequences necessárias.

## Compilação e Execução

### Compilar o projeto

```bash
mvn clean compile
```

### Executar em modo desenvolvimento (Live Reload)

```bash
mvn quarkus:dev
```

A aplicação estará disponível em: `http://localhost:8080`

## 🌐 Tabela de Endpoints

| URI | Verbo | Request Body | Response Body | Status | Descrição |
|---|---|---|---|---|---|
| `/api/usuarios` | GET | - | `List<Usuario>` | 200 | Lista todos os usuários. |
| `/api/usuarios/{id}` | GET | - | `Usuario` | 200/404 | Busca usuário por ID. |
| `/api/usuarios` | POST | `Usuario` | `Usuario` | 201/400 | Cria novo usuário. Retorna 201 com `Location`. |
| `/api/usuarios/{id}` | PUT | `Usuario` | `Usuario` | 200/400/404 | Atualiza usuário. |
| `/api/usuarios/{id}` | DELETE | - | - | 204/404 | Remove usuário. |
| `/api/cursos` | GET | - | `List<Curso>` | 200 | Lista todos os cursos. |
| `/api/cursos` | POST | `Curso` | `Curso` | 201/400 | Cria novo curso. |
| `/api/habilidades` | GET | - | `List<Habilidade>` | 200 | Lista todas as habilidades. |
| `/api/habilidades` | POST | `Habilidade` | `Habilidade` | 201/400 | Cria nova habilidade. |
| `/api/usuario-habilidades` | GET | - | `List<UsuarioHabilidade>` | 200 | Lista todas as associações. |
| `/api/usuario-habilidades` | POST | `UsuarioHabilidade` | `UsuarioHabilidade` | 201/400 | Associa habilidade a usuário. |
| `/api/usuario-habilidades/usuario/{usuarioId}` | GET | - | `List<UsuarioHabilidade>` | 200/404 | Lista habilidades de um usuário. |
| `/api/recomendacoes` | GET | - | `List<Recomendacao>` | 200 | Lista todas as recomendações. |
| `/api/recomendacoes` | POST | `Recomendacao` | `Recomendacao` | 201/400 | Cria nova recomendação. |
| `/api/recomendacoes/usuario/{usuarioId}` | GET | - | `List<Recomendacao>` | 200/404 | Lista recomendações para um usuário (ordenado por prioridade). |

## 🔗 Documentação Adicional

- **Swagger UI:** `http://localhost:8080/swagger`
- **OpenAPI JSON:** `http://localhost:8080/openapi`
