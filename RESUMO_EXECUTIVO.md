# Resumo Executivo - API Futurize

## Informações do Projeto

**Disciplina:** Domain Driven Design Using Java (Quarkus)  
**Data de Entrega:** Novembro 2025  
**Versão:** 1.0.0

### Equipe

| Nome | RM |
|---|---|
| Gabriel Maciel Alves de Oliveira | 562795 |
| Thomas Mineu Fontes | 562254 |
| Matheus Pereira Molina | 563399 |

## Objetivo e Escopo

O objetivo deste projeto é desenvolver uma API RESTful robusta e escalável utilizando o framework **Quarkus** e a especificação **JPA/Hibernate** para persistência de dados no banco **Oracle**. O escopo da API é o gerenciamento de um sistema de recomendação de cursos e habilidades, abrangendo as entidades `Usuario`, `Curso`, `Habilidade`, `UsuarioHabilidade` e `Recomendacao`.

## Descrição da Solução

A solução implementa a arquitetura em camadas **Model/Repository/Service/Resource**, seguindo os princípios do Domain Driven Design (DDD) e do padrão MVC.

- **Model (Domain):** Entidades JPA com mapeamento e `Bean Validation`.
- **Repository (DAO):** Camada de acesso a dados com `EntityManager` injetado.
- **Service (BO):** Camada de regras de negócio e controle transacional (`@Transactional`).
- **Resource (API):** Camada de exposição dos endpoints REST.

O projeto está configurado para se conectar a um banco de dados Oracle e possui todas as configurações necessárias para deploy em ambiente de produção (CORS, OpenAPI).

## Principais Funcionalidades

- **CRUD Completo** para as entidades `Usuario`, `Curso` e `Habilidade`.
- **Associação de Habilidades** a usuários com nível de proficiência (`UsuarioHabilidade`).
- **Gerenciamento de Recomendações** de cursos para usuários.
- **Consulta de Habilidades** e **Recomendações** por usuário.
- **Validação de Dados** em nível de entidade (`Bean Validation`).
- **Tratamento de Exceções** centralizado para `404 Not Found` e `400 Bad Request`.

## Destaques Implementados

- **Arquitetura em Camadas:** Separação clara de responsabilidades (Model/Repository/Service/Resource).
- **Boas Práticas REST:** Implementação de status HTTP corretos (201 Created com Location, 204 No Content).
- **Tratamento de Exceções:** Uso de `ExceptionMapper` para converter exceções de negócio (`NotFoundException`, `ValidationException`) em respostas HTTP adequadas.
- **Validação de Negócio:** Regra de e-mail único implementada no `UsuarioService`.
- **Configuração de Produtividade:** OpenAPI/Swagger configurado para documentação automática em `/swagger`.

## Estrutura de Diretórios

```
futurize-api/
├── database/
│   ├── create_tables.sql          # DDL das tabelas
│   └── insert_sample_data.sql     # Dados de exemplo
├── src/main/java/com/futurize/
│   ├── api/                       # Resources REST
│   │   └── exception/             # Exception Mappers
│   ├── domain/                    # Entidades JPA (Model)
│   ├── repository/                # DAO
│   ├── service/                   # Regras/BO
│   └── config/                    # Configurações (se necessário)
├── src/main/resources/
│   └── application.properties     # Configurações
├── pom.xml                        # Dependências Maven
├── README.md                      # Documentação principal
├── RESUMO_EXECUTIVO.md            # Este arquivo
└── postman_collection.json        # Collection para testes
```

## URLs de Documentação

- **Swagger UI:** `http://localhost:8080/swagger`
- **OpenAPI JSON:** `http://localhost:8080/openapi`

## Testes Mínimos (Aceitação)

A collection do Postman (`postman_collection.json`) contém requisições prontas para testar o CRUD completo e os endpoints de consulta por usuário.

### Exemplo de Teste (cURL)

**Criar Usuário:**
```bash
curl -X POST http://HOST/api/usuarios -H "Content-Type: application/json" \
 -d '{"nome":"Ana","email":"ana@futurize.com","ativo":"S"}'
```

**Listar Usuários:**
```bash
curl http://HOST/api/usuarios
```

**Deletar Usuário:**
```bash
curl -X DELETE http://HOST/api/usuarios/1
```

## Conformidade com a Rubrica

| Item da Rubrica | Status | Observação |
|---|---|---|
| Model (JPA) | ✅ | 5 entidades com mapeamento correto e Bean Validation. |
| DAO/Repository | ✅ | 5 Repositories com CRUD e consultas úteis. |
| Service (BO) | ✅ | 5 Services com regras de negócio e `@Transactional`. |
| Resource (REST) | ✅ | 5 Resources com endpoints corretos, CORS e status HTTP. |
| Boas Práticas | ✅ | Pacotes, exceções, nomes consistentes. |
| Deploy | ⚙️ | Código pronto para deploy (instruções no README). |
| Documentação | ✅ | README, Resumo Executivo, SQL, Postman. |

O projeto está pronto para ser empacotado e entregue.
