# API REST Endpoints - Repair Tips System

## Base URL
```
http://localhost:8080/api
```

---

## Fabricantes (`/v1/fabricantes`)

### POST - Criar Fabricante
```
POST /v1/fabricantes
Content-Type: application/json

{
  "nome": "HP Inc.",
  "sigla": "HP"
}

Response: 201 Created
{
  "id": 1,
  "nome": "HP Inc.",
  "sigla": "HP"
}
```

### GET - Listar Fabricantes
```
GET /v1/fabricantes?page=0&size=10

Response: 200 OK
{
  "content": [
    {
      "id": 1,
      "nome": "HP Inc.",
      "sigla": "HP"
    }
  ],
  "pageable": {...},
  "totalElements": 1,
  "totalPages": 1
}
```

### GET - Listar Todos os Fabricantes
```
GET /v1/fabricantes/todos

Response: 200 OK
[
  {
    "id": 1,
    "nome": "HP Inc.",
    "sigla": "HP"
  }
]
```

### GET - Obter por ID
```
GET /v1/fabricantes/{id}

Response: 200 OK
{
  "id": 1,
  "nome": "HP Inc.",
  "sigla": "HP"
}
```

### GET - Obter por Nome
```
GET /v1/fabricantes/nome/{nome}

Response: 200 OK
{
  "id": 1,
  "nome": "HP Inc.",
  "sigla": "HP"
}
```

### PUT - Atualizar Fabricante
```
PUT /v1/fabricantes/{id}
Content-Type: application/json

{
  "nome": "HP Inc.",
  "sigla": "HP"
}

Response: 200 OK
```

### DELETE - Deletar Fabricante
```
DELETE /v1/fabricantes/{id}

Response: 204 No Content
```

---

## Equipamentos (`/v1/equipamentos`)

### POST - Criar Equipamento
```
POST /v1/equipamentos
Content-Type: application/json

{
  "modelo": "LaserJet Pro M404n",
  "categoria": "IMPRESSORA",
  "tipo": "laser",
  "fabricanteId": 1
}

Response: 201 Created
{
  "id": 1,
  "modelo": "LaserJet Pro M404n",
  "categoria": "IMPRESSORA",
  "tipo": "laser",
  "fabricante": {
    "id": 1,
    "nome": "HP Inc.",
    "sigla": "HP"
  }
}
```

### GET - Listar Equipamentos
```
GET /v1/equipamentos?page=0&size=10

Response: 200 OK
```

### GET - Listar por Categoria
```
GET /v1/equipamentos/categoria/{categoria}?page=0&size=10

Categorias: IMPRESSORA, SCANNER, COPIADORA, MULTIFUNCIONAL, FAX, PROJETOR, MONITOR, COMPUTADOR, SERVIDOR, IMPRESSORA_3D, OUTRO

Response: 200 OK
```

### GET - Listar por Tipo
```
GET /v1/equipamentos/tipo/{tipo}?page=0&size=10

Response: 200 OK
```

### GET - Listar por Fabricante
```
GET /v1/equipamentos/fabricante/{fabricanteId}?page=0&size=10

Response: 200 OK
```

### GET - Obter por ID
```
GET /v1/equipamentos/{id}

Response: 200 OK
```

### GET - Buscar por Modelo
```
GET /v1/equipamentos/buscar-por-modelo?modelo=LaserJet

Response: 200 OK (Lista)
```

### PUT - Atualizar Equipamento
```
PUT /v1/equipamentos/{id}
Content-Type: application/json

{
  "modelo": "LaserJet Pro M404n",
  "categoria": "IMPRESSORA",
  "tipo": "laser",
  "fabricanteId": 1
}

Response: 200 OK
```

### DELETE - Deletar Equipamento
```
DELETE /v1/equipamentos/{id}

Response: 204 No Content
```

---

## Dicas (`/v1/dicas`)

### POST - Criar Dica
```
POST /v1/dicas
Content-Type: application/json

{
  "problemDescricao": "Papel preso na impressora durante a impressão de documentos.",
  "solucaoDescricao": "1. Desligue a impressora. 2. Abra o painel de acesso. 3. Remova o papel preso com cuidado. 4. Religue a impressora."
}

Response: 201 Created
{
  "id": 1,
  "problemDescricao": "Papel preso na impressora durante a impressão de documentos.",
  "solucaoDescricao": "1. Desligue a impressora. 2. Abra o painel de acesso. 3. Remova o papel preso com cuidado. 4. Religue a impressora.",
  "dataCriacao": "2026-03-17T10:30:00",
  "dataAtualizacao": "2026-03-17T10:30:00",
  "ativo": true,
  "equipamentos": [],
  "pecas": []
}
```

### GET - Listar Dicas
```
GET /v1/dicas?page=0&size=10

Response: 200 OK (retorna apenas dicas ativas)
```

### GET - Listar Todas as Dicas
```
GET /v1/dicas/todas

Response: 200 OK (Lista mesmo que paginado)
```

### GET - Obter por ID
```
GET /v1/dicas/{id}

Response: 200 OK
```

### GET - Buscar por Problema
```
GET /v1/dicas/buscar-por-problema?problema=papel%20preso

Response: 200 OK (Lista)
```

### GET - Buscar por Equipamento
```
GET /v1/dicas/equipamento/{equipamentoId}

Response: 200 OK (Lista de dicas para esse equipamento)
```

### GET - Buscar por Peça
```
GET /v1/dicas/peca/{pecaId}

Response: 200 OK (Lista de dicas que mencionam essa peça)
```

### GET - Buscar por Fabricante
```
GET /v1/dicas/fabricante/{siglFabricante}

Response: 200 OK (Lista de dicas para equipamentos desse fabricante)
```

### PUT - Atualizar Dica
```
PUT /v1/dicas/{id}
Content-Type: application/json

{
  "problemDescricao": "...",
  "solucaoDescricao": "..."
}

Response: 200 OK
```

### DELETE - Deletar Dica (Soft Delete)
```
DELETE /v1/dicas/{id}

Response: 204 No Content (marca como inativo)
```

### POST - Reativar Dica
```
POST /v1/dicas/{id}/reativar

Response: 204 No Content
```

---

## Peças (`/v1/pecas`)

### POST - Criar Peça
```
POST /v1/pecas
Content-Type: application/json

{
  "nome": "Rolo de Pressão",
  "partNumber": "RM1-4426-000CN",
  "categoria": "Consumível"
}

Response: 201 Created
{
  "id": 1,
  "nome": "Rolo de Pressão",
  "partNumber": "RM1-4426-000CN",
  "categoria": "Consumível"
}
```

### GET - Listar Peças
```
GET /v1/pecas?page=0&size=10

Response: 200 OK
```

### GET - Listar por Nome
```
GET /v1/pecas/nome/{nome}?page=0&size=10

Response: 200 OK
```

### GET - Listar por Categoria
```
GET /v1/pecas/categoria/{categoria}?page=0&size=10

Response: 200 OK
```

### GET - Obter por ID
```
GET /v1/pecas/{id}

Response: 200 OK
```

### GET - Obter por Part Number
```
GET /v1/pecas/part-number/{partNumber}

Response: 200 OK
```

### GET - Buscar por Termo
```
GET /v1/pecas/buscar?termo=rolo&page=0&size=10

Response: 200 OK (busca em nome e partNumber)
```

### GET - Obter Peças de Equipamento
```
GET /v1/pecas/equipamento/{equipamentoId}?page=0&size=10

Response: 200 OK
```

### PUT - Atualizar Peça
```
PUT /v1/pecas/{id}
Content-Type: application/json

{
  "nome": "Rolo de Pressão",
  "partNumber": "RM1-4426-000CN",
  "categoria": "Consumível"
}

Response: 200 OK
```

### DELETE - Deletar Peça
```
DELETE /v1/pecas/{id}

Response: 204 No Content
```

---

## Códigos de Status HTTP

- `200 OK`: Requisição bem-sucedida
- `201 Created`: Recurso criado com sucesso
- `204 No Content`: Requisição bem-sucedida sem corpo de resposta
- `400 Bad Request`: Erro de validação ou parâmetros inválidos
- `404 Not Found`: Recurso não encontrado
- `409 Conflict`: Conflito (ex: duplicidade)
- `500 Internal Server Error`: Erro no servidor

---

## Exemplo de Fluxo Completo

1. **Criar Fabricante**
   ```bash
   curl -X POST http://localhost:8080/api/v1/fabricantes \
     -H "Content-Type: application/json" \
     -d '{"nome":"HP Inc.","sigla":"HP"}'
   ```

2. **Criar Equipamento**
   ```bash
   curl -X POST http://localhost:8080/api/v1/equipamentos \
     -H "Content-Type: application/json" \
     -d '{"modelo":"LaserJet Pro","categoria":"IMPRESSORA","tipo":"laser","fabricanteId":1}'
   ```

3. **Criar Peça**
   ```bash
   curl -X POST http://localhost:8080/api/v1/pecas \
     -H "Content-Type: application/json" \
     -d '{"nome":"Rolo de Pressão","partNumber":"RM1-4426","categoria":"Consumível"}'
   ```

4. **Criar Dica**
   ```bash
   curl -X POST http://localhost:8080/api/v1/dicas \
     -H "Content-Type: application/json" \
     -d '{"problemDescricao":"Papel preso...","solucaoDescricao":"1. Desligue..."}'
   ```

5. **Buscar Dicas por Equipamento**
   ```bash
   curl http://localhost:8080/api/v1/dicas/equipamento/1
   ```

---

**Versão da API**: 1.0  
**Data**: 17 de março de 2026
