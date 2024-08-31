# Categoria e Produtos API

Esta é uma aplicação desenvolvida em Spring Boot (versão 3.3.3), que implementa um serviço RESTful para gerenciar categorias e seus produtos associados. A aplicação utiliza o banco de dados em memória H2.

## Funcionalidades

- **Categorias**: Gerencie categorias de produtos.
  - **Buscar Categoria por ID**: Recupera uma categoria pelo seu ID, juntamente com os produtos associados a essa categoria.

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