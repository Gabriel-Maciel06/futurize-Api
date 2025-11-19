# ✅ Código Ajustado para a Estrutura do Oracle

## 🔄 Mudanças Realizadas

Ajustei **todas as entidades JPA** para corresponder **exatamente** à estrutura das tabelas Oracle que você criou.

## 📊 Principais Diferenças Corrigidas

### 1. Geração de IDs
**Antes:** `SEQUENCE` (sq_fz_*)  
**Agora:** `IDENTITY` (GENERATED ALWAYS AS IDENTITY)

```java
// ANTES
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
@SequenceGenerator(name = "curso_seq", sequenceName = "sq_fz_curso", allocationSize = 1)

// AGORA
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

### 2. Usuario
**Novo campo:**
- `ds_email` agora aceita até 150 caracteres (era 100)

### 3. Curso
**Campos removidos:**
- ❌ `ds_curso` (descrição)

**Campos adicionados:**
- ✅ `ds_categoria` (String, 60 chars) - Ex: "Backend", "Frontend"
- ✅ `qt_carga_horaria` (Integer) - Ex: 80, 60, 100
- ✅ `ds_nivel` (String, 20 chars) - "Iniciante", "Intermediario", "Avancado"

```java
// Estrutura antiga
{
  "nome": "Java Advanced",
  "descricao": "Curso de Java"
}

// Estrutura nova
{
  "nome": "Java Advanced - Quarkus e Microservices",
  "categoria": "Backend",
  "cargaHoraria": 80,
  "nivel": "Avancado"
}
```

### 4. Habilidade
**Campos removidos:**
- ❌ `ds_habilidade` (descrição)

**Campos adicionados:**
- ✅ `ds_categoria` (String, 60 chars) - Ex: "Linguagem", "Framework"
- ✅ `ds_nivel` (String, 20 chars) - "Iniciante", "Intermediario", "Avancado"

```java
// Estrutura antiga
{
  "nome": "Java",
  "descricao": "Linguagem de programação"
}

// Estrutura nova
{
  "nome": "Java",
  "categoria": "Linguagem de Programação",
  "nivel": "Avancado"
}
```

### 5. UsuarioHabilidade
**Campos alterados:**
- ❌ `nr_nivel` (0-5) → ✅ `nu_proficiencia` (0-100)

**Campos adicionados:**
- ✅ `dt_atualizacao` (LocalDate) - Automático via @PrePersist/@PreUpdate

```java
// Estrutura antiga
{
  "usuario": {...},
  "habilidade": {...},
  "nivel": 4  // 0-5
}

// Estrutura nova
{
  "usuario": {...},
  "habilidade": {...},
  "proficiencia": 85,  // 0-100 (%)
  "dataAtualizacao": "2025-11-19"
}
```

### 6. Recomendacao
**Campos alterados:**
- Prioridade continua 1-5 (mas agora validado corretamente)

**Campos adicionados:**
- ✅ `dt_recomendacao` (LocalDate) - Automático
- ✅ `ds_motivo` (String, 200 chars) - Opcional

```java
// Estrutura antiga
{
  "usuario": {...},
  "curso": {...},
  "prioridade": 8
}

// Estrutura nova
{
  "usuario": {...},
  "curso": {...},
  "prioridade": 5,  // 1-5
  "dataRecomendacao": "2025-11-19",
  "motivo": "Alta proficiência em Java, curso perfeito para especialização"
}
```

## 📁 Arquivos Modificados

### Entidades (Domain)
- ✅ `Usuario.java` - IDENTITY + email 150 chars
- ✅ `Curso.java` - IDENTITY + categoria, cargaHoraria, nivel
- ✅ `Habilidade.java` - IDENTITY + categoria, nivel
- ✅ `UsuarioHabilidade.java` - IDENTITY + proficiencia 0-100, dataAtualizacao
- ✅ `Recomendacao.java` - IDENTITY + dataRecomendacao, motivo

### Services
- ✅ `CursoService.java` - Update usando novos campos
- ✅ `HabilidadeService.java` - Update usando novos campos
- ✅ `UsuarioHabilidadeService.java` - Update usando proficiencia

### Novos Arquivos
- ✅ `database/insert_data_new_structure.sql` - Dados de exemplo compatíveis

## 🚀 Como Testar

### 1. Inserir dados no Oracle
```bash
sqlplus RM562254/280406@oracle.fiap.com.br:1521/ORCL
@database/insert_data_new_structure.sql
```

### 2. Fazer deploy da API atualizada
```bash
git add .
git commit -m "fix: ajustar entidades para nova estrutura do Oracle"
git push origin main
```

### 3. Testar os endpoints
```bash
# Listar cursos (deve retornar com categoria, cargaHoraria, nivel)
curl https://futurize-api-production.up.railway.app/api/cursos

# Criar novo curso
curl -X POST https://futurize-api-production.up.railway.app/api/cursos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Node.js Essentials",
    "categoria": "Backend",
    "cargaHoraria": 45,
    "nivel": "Iniciante"
  }'
```

## 📝 Exemplos de JSON para Testes

### Criar Curso
```json
{
  "nome": "Node.js com Express",
  "categoria": "Backend",
  "cargaHoraria": 50,
  "nivel": "Intermediario"
}
```

### Criar Habilidade
```json
{
  "nome": "TypeScript",
  "categoria": "Linguagem de Programação",
  "nivel": "Intermediario"
}
```

### Criar Usuário-Habilidade
```json
{
  "usuario": {"id": 1},
  "habilidade": {"id": 2},
  "proficiencia": 75
}
```

### Criar Recomendação
```json
{
  "usuario": {"id": 1},
  "curso": {"id": 2},
  "prioridade": 5,
  "motivo": "Curso recomendado com base no perfil do usuário"
}
```

## ✅ Resultado Esperado

Após fazer deploy e inserir os dados:

- ✅ `/api/cursos` → HTTP 200 com 8 cursos
- ✅ `/api/habilidades` → HTTP 200 com 10 habilidades
- ✅ `/api/usuario-habilidades` → HTTP 200 com 9 relações
- ✅ `/api/recomendacoes` → HTTP 200 com 10 recomendações

## 🎯 Próximos Passos

1. Execute `insert_data_new_structure.sql` no Oracle
2. Faça commit e push das mudanças
3. Aguarde deploy no Railway
4. Teste os endpoints!

**Tudo está pronto para funcionar! 🎉**
