# Jewelry-ERP

## Descrição
Este projeto é uma API REST para gerenciar informações sobre joias. Ele permite criar, listar e buscar detalhes de joias armazenadas no sistema. A aplicação foi desenvolvida em Java utilizando o framework Spring Boot.

## Funcionalidades
- **Inserir Joias:** Endpoint para adicionar novas joias ao sistema.
- **Listar Joias:** Endpoint para listar todas as joias cadastradas.
- **Buscar Joia por ID:** Endpoint para buscar os detalhes de uma joia utilizando seu UUID.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 2.7.x**
  - Spring Web
  - Spring Data JPA
- **Validation**
- **H2 Database** (banco de dados em memória para desenvolvimento/testes)
- **Maven** (gerenciador de dependências)

## Estrutura do Projeto
- **`controllers`**: Contém os endpoints da API.
- **`services`**: Lógica de negócio para manipulação de dados.
- **`repositories`**: Integração com o banco de dados usando Spring Data JPA.
- **`dtos`**: Classes para transferência de dados entre camadas (Request/Response).
- **`mappers`**: Conversões entre entidades do banco de dados e DTOs.
- **`models`**: Representações das entidades do banco de dados.

## Endpoints
### **1. Inserir Joia**
`POST /jewelry`

**Request Body:**
```json
{
  "price": 2000.0,
  "metal": "Gold",
  "gemstone": "Diamond"
}
```

**Response:**
```json
{
  "price": 2000.0,
  "metal": "Gold",
  "gemstone": "Diamond"
}
```

### **2. Listar Todas as Joias**
`GET /jewelry`

**Response:**
```json
[
  {
    "price": 2000.0,
    "metal": "Gold",
    "gemstone": "Diamond"
  },
  {
    "price": 1500.0,
    "metal": "Silver",
    "gemstone": "Ruby"
  }
]
```

### **3. Buscar Joia por ID**
`GET /jewelry/{id}`

**Path Variable:**
- `id`: UUID da joia a ser buscada

**Response:**
```json
{
  "price": 2000.0,
  "metal": "Gold",
  "gemstone": "Diamond"
}
```

**Erro (ID Inválido):**
```json
{
  "status": "INTERNAL_SERVER_ERROR",
  "reason": "Jóia não encontrada"
}
```
### **4. Buscar Joia por ID**
`GET /jewelry/profit?id={id}&profit={profit}`

**Request Param:**
- `id`: UUID da joia a ser buscada
- `profit`: Float do lucro de venda

**Response:**
```json
{
  "price": 2000.0,
  "metal": "Gold",
  "gemstone": "Diamond"
}
```

**Erro (ID Inválido):**
```json
{
  "status": "INTERNAL_SERVER_ERROR",
  "reason": "Jóia não encontrada"
}
```

### **5. Deletar Joia por ID**
`DELETE /jewelry/{id}`

**Path Variable:**
- `id`: UUID da joia a ser deletada

**Response:**
```json
{
  "price": 2000.0,
  "metal": "Gold",
  "gemstone": "Diamond"
}
```

**Erro (ID Inválido):**
```json
{
  "status": "INTERNAL_SERVER_ERROR",
  "reason": "Jóia não encontrada"
}
```

## Como Rodar o Projeto

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

## Configuração do Banco de Dados
O projeto utiliza o H2 Database para fins de desenvolvimento. O console do H2 pode ser acessado em:

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

**Configurações Padrão:**
- **URL:** `jdbc:h2:file:./DataCenter.db`
- **Usuário:** (em branco)
- **Senha:** (em branco)

---

Desenvolvido por **Silvio Virtuoso** & **Vitor Koch Wessler** com Spring Boot e Java.
