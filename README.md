# Minha API

Esta api usa autenticação para acessar os endpoint de acrodo com sua role. Usei meu conhecimento com Spring Security e JWT.

## Base URL

```
/auth
```

## Autenticação

A API utiliza autenticação via token JWT.

```
Authorization: Bearer <seu_token>
```

## Endpoints

### 1. Registrar usuário

**GET** `/register`


**Corpo da requisição:**
```json
{
  "username": "joao@email.com",
  "password": "123456",
  "userRole": "ADMIN"
}
```

### 2. Logar usuário

**GET** `/login`


**Corpo da requisição:**
```json
{
  "username": "joao@email.com",
  "password": "123456"
}
```

## Base URL

```
/products
```

## Endpoints

### 1. Salvar produto

**GET** `/save`


**Corpo da requisição:**
```json
{
  "name": "Garrafa d'agua",
  "quantity": 50,
  "price": 15
}
```

### 2. Listar todos os produtos

**GET**


**Exemplo de resposta:**
```json
[ {
    "name": "Garrafa d'agua",
    "quantity": 50,
    "price": 15
  },
  {
    "name": "mouse preto",
    "quantity": 20,
    "price": 30
  }
]
```

### 3. Procurar produto por id

**GET** `/{id}`


**Exemplo de resposta:**
```json
{
  "name": "Garrafa d'agua",
  "quantity": 50,
  "price": 15
}
```
