# Experimentando o Spring

Aplicação desenvolvida em Spring Boot (versão 3.3.3), que implementa um serviço RESTful para gerenciar categorias, produtos associados, e dados de clientes. A aplicação utiliza o banco de dados em memória H2.

## Arquitetura

A aplicação segue uma **Arquitetura em Camadas**, que organiza o código em diferentes camadas de responsabilidade, facilitando a manutenção e escalabilidade. As principais camadas são:

- **Camada de Apresentação (Controller)**: Esta camada é responsável por expor os endpoints REST, processar as requisições HTTP, e retornar as respostas apropriadas. Utiliza o Spring MVC para mapear as requisições para os métodos correspondentes.

- **Camada de Serviço (Service)**: Contém a lógica de negócios da aplicação. Nessa camada, são implementadas as regras de negócio e a lógica necessária para atender os casos de uso específicos da aplicação. Ela também faz a intermediação entre a camada de apresentação e a camada de persistência.

- **Camada de Persistência (Repository)**: Responsável por acessar e manipular os dados no banco de dados. Utiliza o Spring Data JPA para abstrair as operações de CRUD e outras interações com o banco de dados. Nesta aplicação, o banco de dados utilizado é o H2, um banco em memória que facilita o desenvolvimento e testes.

- **Camada de Domínio**: Representa os modelos de domínio, que são as entidades principais da aplicação, como `Categoria`, `Produto`, e `Cliente`. Esses modelos contêm as regras de negócio relacionadas aos dados que representam.

## Padrão de Desenvolvimento

A aplicação segue o **padrão de desenvolvimento orientado a casos de uso**, onde cada funcionalidade é implementada para resolver um caso de uso específico. Além disso, utiliza o **Mapeamento Objeto-Relacional (ORM)** com JPA para mapear as entidades de domínio para as tabelas do banco de dados, facilitando a persistência dos dados.

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
