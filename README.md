# Categoria e Produtos API

Esta é uma aplicação desenvolvida em Spring Boot (versão 3.3.3), que implementa um serviço RESTful para gerenciar categorias, produtos associados, e dados de clientes. A aplicação utiliza o banco de dados em memória H2.

## Funcionalidades

- **Categorias**: Gerencie categorias de produtos.
  - **Buscar Categoria por ID**: Recupera uma categoria pelo seu ID, juntamente com os produtos associados a essa categoria.
- **Clientes**: Gerencie os dados dos clientes.
  - **Buscar Cliente por ID**: Recupera informações de um cliente específico pelo seu ID, incluindo nome, e-mail, CPF ou CNPJ, tipo do cliente, endereços e números de telefone.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Data JPA**
- **H2 Database**

## Endpoints

### Buscar Categoria por ID

- **URL**: `/api/categorias/{id}`
- **Método HTTP**: `GET`
- **Descrição**: Retorna uma categoria específica pelo seu ID. A resposta inclui uma lista de produtos que pertencem a essa categoria.

### Buscar Cliente por ID

- **URL**: `/api/clientes/{id}`
- **Método HTTP**: `GET`
- **Descrição**: Retorna os dados de um cliente específico pelo seu ID. A resposta inclui nome, e-mail, CPF ou CNPJ, tipo do cliente, endereços e números de telefone.
