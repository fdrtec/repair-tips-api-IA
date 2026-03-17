# Repair Tips API - Sistema de Consulta de Dicas de Conserto

API REST desenvolvida com **Java 17**, **Spring Boot 3.4.1** e **SQL Server**, para gerenciar um sistema de consulta de dicas de conserto de equipamentos.

---

## 📋 Índice

- [Tecnologias](#tecnologias)
- [Requisitos](#requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar](#como-executar)
- [Testes](#testes)
- [API Endpoints](#api-endpoints)
- [Arquitetura](#arquitetura)
- [Boas Práticas Implementadas](#boas-práticas-implementadas)

---

## 🛠️ Tecnologias

- **Java 17** (LTS)
- **Spring Boot 3.4.1**
- **Spring Data JPA** (ORM)
- **SQL Server 2019+**
- **Maven** (Gerenciador de dependências)
- **Lombok** (Redução de boilerplate)
- **MapStruct** (Mapeamento DTO/Entity)
- **JUnit 5** (Testes unitários)
- **Mockito** (Mock de dependências)

---

## 📦 Requisitos

- **JDK 17+** instalado e configurado
- **Maven 3.8+**
- **SQL Server 2019+** com banco de dados criado
- **IDE**: VS Code, IntelliJ IDEA ou Eclipse

### Verificar Instalação

```bash
# Verificar Java
java -version

# Verificar Maven
mvn -version
```

---

## 🚀 Instalação

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/repair-tips-api-IA.git
cd repair-tips-api-IA
```

### 2. Instalar Dependências

```bash
mvn clean install
```

### 3. Criar Banco de Dados (SQL Server)

```sql
CREATE DATABASE repair_system;

USE repair_system;
```

---

## ⚙️ Configuração

### application.properties

Edite `src/main/resources/application.properties` com suas credenciais SQL Server:

```properties
# SQL Server Configuration
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=repair_system;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=YourPassword123!
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.dialect=org.hibernate.dialect.SQLServerDialect
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true

# Server Port
server.port=8080
server.servlet.context-path=/api
```

**Notas Importantes:**

- `ddl-auto=update`: Cria/atualiza tabelas automaticamente na primeira execução
- `ddl-auto=validate`: Use em produção para apenas validar o schema
- `trustServerCertificate=true`: Aceita certificados autoassinados (apenas desenvolvimento)

---

## 📁 Estrutura do Projeto

```
repair-tips-api-IA/
├── src/main/java/com/repairsystem/
│   ├── controller/           # REST Controllers (endpoints)
│   │   ├── FabricanteController.java
│   │   ├── EquipamentoController.java
│   │   ├── DicaController.java
│   │   └── PecaController.java
│   ├── service/              # Camada de lógica de negócio
│   │   ├── FabricanteService.java
│   │   ├── EquipamentoService.java
│   │   ├── DicaService.java
│   │   └── PecaService.java
│   ├── repository/           # Data Access Layer (JPA)
│   │   ├── FabricanteRepository.java
│   │   ├── EquipamentoRepository.java
│   │   ├── DicaRepository.java
│   │   └── PecaRepository.java
│   ├── domain/
│   │   ├── entity/           # Entidades JPA
│   │   │   ├── Fabricante.java
│   │   │   ├── Equipamento.java
│   │   │   ├── Dica.java
│   │   │   └── Peca.java
│   │   └── enums/
│   │       └── CategoriaEquipamento.java
│   ├── dto/                  # Data Transfer Objects
│   │   ├── request/          # DTOs de entrada
│   │   └── response/         # DTOs de saída
│   ├── mapper/               # MapStruct mappers
│   │   ├── FabricanteMapper.java
│   │   ├── EquipamentoMapper.java
│   │   ├── DicaMapper.java
│   │   └── PecaMapper.java
│   ├── exception/            # Tratamento de exceções
│   │   ├── EntityNotFoundException.java
│   │   ├── DuplicateEntityException.java
│   │   ├── GlobalExceptionHandler.java
│   │   └── ErrorResponse.java
│   └── RepairApiApplication.java
├── src/test/java/com/repairsystem/
│   ├── service/              # Testes de Services
│   │   ├── FabricanteServiceTest.java
│   │   ├── DicaServiceTest.java
│   │   └── PecaServiceTest.java
│   └── controller/           # Testes de Controllers
│       └── FabricanteControllerTest.java
├── src/main/resources/
│   └── application.properties
├── pom.xml                   # Configuração Maven
├── API-ENDPOINTS.md          # Documentação dos endpoints
└── README.md                 # Este arquivo

## ▶️ Como Executar

### via IDE

1. Abra o projeto em sua IDE
2. Clique em **Run** → **Run 'RepairApiApplication.java'**
3. Aguarde a inicialização (aproximadamente 10-15 segundos)

### via Terminal

```bash
# Compilar e executar
mvn spring-boot:run

# Ou compilar e executar com java
mvn clean package
java -jar target/repair-tips-api-1.0.0.jar
```

### Verificar se está rodando

```bash
curl http://localhost:8080/api/v1/fabricantes
```

---

## 🧪 Testes

### Executar Todos os Testes

```bash
mvn test
```

### Executar Teste Específico

```bash
mvn test -Dtest=FabricanteServiceTest
```

### Cobertura de Testes

```bash
mvn test jacoco:report
# Abra target/site/jacoco/index.html
```

### Padrão de Testes Utilizado: **AAA (Arrange, Act, Assert)**

```java
@Test
@DisplayName("Deve criar um novo fabricante com sucesso")
void testCriarComSucesso() {
    // Arrange (preparar dados)
    when(repository.save(any())).thenReturn(fabricante);
    
    // Act (executar)
    FabricanteResponseDTO resultado = service.criar(requestDTO);
    
    // Assert (validar)
    assertThat(resultado).isNotNull();
}
```

---

## 🔗 API Endpoints

### Base URL
```
http://localhost:8080/api
```

## **Fabricantes** (`/v1/fabricantes`)

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| POST | `/v1/fabricantes` | Criar novo fabricante | 201 |
| GET | `/v1/fabricantes` | Listar com paginação | 200 |
| GET | `/v1/fabricantes/todos` | Listar todos | 200 |
| GET | `/v1/fabricantes/{id}` | Obter por ID | 200 |
| GET | `/v1/fabricantes/nome/{nome}` | Obter por nome | 200 |
| PUT | `/v1/fabricantes/{id}` | Atualizar | 200 |
| DELETE | `/v1/fabricantes/{id}` | Deletar | 204 |

## **Equipamentos** (`/v1/equipamentos`)

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| POST | `/v1/equipamentos` | Criar equipamento | 201 |
| GET | `/v1/equipamentos` | Listar com paginação | 200 |
| GET | `/v1/equipamentos/categoria/{categoria}` | Listar por categoria | 200 |
| GET | `/v1/equipamentos/tipo/{tipo}` | Listar por tipo | 200 |
| GET | `/v1/equipamentos/fabricante/{fabricanteId}` | Listar por fabricante | 200 |
| GET | `/v1/equipamentos/{id}` | Obter por ID | 200 |
| GET | `/v1/equipamentos/buscar-por-modelo` | Buscar por modelo | 200 |
| PUT | `/v1/equipamentos/{id}` | Atualizar | 200 |
| DELETE | `/v1/equipamentos/{id}` | Deletar | 204 |

## **Dicas** (`/v1/dicas`)

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| POST | `/v1/dicas` | Criar dica | 201 |
| GET | `/v1/dicas` | Listar com paginação | 200 |
| GET | `/v1/dicas/todas` | Listar todas | 200 |
| GET | `/v1/dicas/{id}` | Obter por ID | 200 |
| GET | `/v1/dicas/buscar-por-problema` | Buscar por problema | 200 |
| GET | `/v1/dicas/equipamento/{equipamentoId}` | Dicas de equipamento | 200 |
| GET | `/v1/dicas/peca/{pecaId}` | Dicas de peça | 200 |
| GET | `/v1/dicas/fabricante/{siglFabricante}` | Dicas por fabricante | 200 |
| PUT | `/v1/dicas/{id}` | Atualizar | 200 |
| DELETE | `/v1/dicas/{id}` | Deletar (soft) | 204 |
| POST | `/v1/dicas/{id}/reativar` | Reativar | 204 |

## **Peças** (`/v1/pecas`)

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| POST | `/v1/pecas` | Criar peça | 201 |
| GET | `/v1/pecas` | Listar com paginação | 200 |
| GET | `/v1/pecas/nome/{nome}` | Listar por nome | 200 |
| GET | `/v1/pecas/categoria/{categoria}` | Listar por categoria | 200 |
| GET | `/v1/pecas/{id}` | Obter por ID | 200 |
| GET | `/v1/pecas/part-number/{partNumber}` | Obter por partNumber | 200 |
| GET | `/v1/pecas/buscar` | Buscar por termo | 200 |
| GET | `/v1/pecas/equipamento/{equipamentoId}` | Peças de equipamento | 200 |
| PUT | `/v1/pecas/{id}` | Atualizar | 200 |
| DELETE | `/v1/pecas/{id}` | Deletar | 204 |

**Para documentação completa de endpoints, veja [API-ENDPOINTS.md](API-ENDPOINTS.md)**

---

## 🏗️ Arquitetura

### Padrão em Camadas (Layered Architecture)

```
┌─────────────────────────────────────┐
│        Controller (REST API)         | ← HTTP requests/responses
├─────────────────────────────────────┤
│        Service (Business Logic)      | ← Validações e regras de negócio
├─────────────────────────────────────┤
│      Repository (Data Access)       | ← JPA queries
├─────────────────────────────────────┤
│        Domain (Entity Model)         | ← Objetos de negócio
├─────────────────────────────────────┤
│           SQL Server                | ← Persistência
└─────────────────────────────────────┘
```

### Fluxo de Requisição

```
POST /api/v1/fabricantes
  ↓
FabricanteController.criar(RequestDTO)
  ↓
FabricanteService.criar(RequestDTO)
  ↓
FabricanteRepository.save(Entity)
  ↓
SQL Server (INSERT)
  ↓
ResponseEntity<ResponseDTO> 201 Created
```

---

## ✅ Boas Práticas Implementadas

### 1. **SOLID Principles**
- **S**ingle Responsibility: cada classe tem uma única responsabilidade
- **O**pen/Closed: aberto para extensão, fechado para modificação
- **L**iskov Substitution: interfaces bem definidas e coerentes
- **I**nterface Segregation: interfaces pequenas e específicas
- **D**ependency Inversion: injeção de dependência por construtor

### 2. **Clean Code**
- Nomes descritivos (classes, métodos, variáveis)
- Métodos pequenos e focados
- Sem código duplicado (DRY)
- Validações e tratamento de erros robusto

### 3. **Java 17 Features**
- Records para DTOs imutáveis
- `var` em variáveis locais
- Pattern matching (preparado para futuras evoluções)
- Text blocks em strings (quando necessário)

### 4. **Spring Boot Best Practices**
- Injeção de dependência por construtor (não @Autowired)
- @Transactional para gerenciamento de transações
- Validação com @Valid e anotações de validação (JSR-303)
- GlobalExceptionHandler para centralizar tratamento de erros

### 5. **JPA/Hibernate**
- Mapeamento correto de relacionamentos (1:N, M:N)
- Lazy loading para evitar N+1 queries
- Índices em colunas frequentemente consultadas
- Cascade e orphanRemoval bem configurados

### 6. **Segurança (Fortify)**
- Validação de entrada em todas as requisições
- Uso de JPA para evitar SQL injection
- Sem concatenação de strings em queries
- Não logar dados sensíveis
- Input validation com @Pattern e tamanho máximo

### 7. **Testes**
- Testes unitários com JUnit 5
- Cobertura mínima de 80%
- Mock de dependências com Mockito
- Padrão AAA (Arrange, Act, Assert)
- @DisplayName para testes legíveis

### 8. **Logging**
- SLF4J com Logback
- Níveis apropriados (DEBUG, INFO, WARN, ERROR)
- Sem logs de dados sensíveis

---

## 🔐 Segurança

### Validações Implementadas

1. **Entrada**: Tamanho, padrão, obrigatoriedade
2. **SQL Injection**: JPA Prepared Statements
3. **Duplicidade**: Verificação de unique constraints
4. **Integridade referencial**: Foreign keys e relationships
5. **Soft Delete**: Dicas marcadas como inativas ao invés de deletadas

### Exemplo de Validação

```java
@NotBlank(message = "Nome é obrigatório")
@Size(min = 3, max = 100)
@Pattern(regexp = "^[A-Z0-9\\-]+$")
private String partNumber;
```

---

## 📊 Relacionamentos entre Entidades

```
Fabricante (1) ──────→ (N) Equipamento
                         ↓
                    (M:N) ─────┬───→ (M:N)
                    Equipamento ┼ Dica
                                ├─→ Peça
                    Dica (M:N) ──────→ Peça
```

---

## 🚀 Próximos Passos / Melhorias Futuras

1. **Autenticação & Autorização**: JWT com Spring Security
2. **API Documentation**: Swagger/OpenAPI
3. **Caching**: Redis para dicas frequentes
4. **Full-text Search**: Elasticsearch
5. **Observabilidade**: Prometheus + Grafana
6. **Rate Limiting**: Para produção
7. **HATEOAS**: Links de navegação nas respostas
8. **Versionamento de API**: Múltiplas versões coexistindo

---

## 📞 Suporte e Contribuição

Se encontrar bugs ou tiver sugestões, abra uma issue no repositório.

Para contribuir:
1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nome`)
3. Commit suas mudanças (`git commit -am 'Add feature'`)
4. Push para a branch (`git push origin feature/nome`)
5. Abra um Pull Request

---

## 📝 Licença

Este projeto está sob licença MIT. Veja [LICENSE](LICENSE) para mais detalhes.

---

**Desenvolvido por**: Especialista Java 17 & Spring Boot 3.4.1  
**Data de Criação**: 17 de março de 2026  
**Versão**: 1.0.0

