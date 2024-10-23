# Todo List - Gerenciamento de Tarefas

Este é um projeto de Todo List para gerenciamento de tarefas, com funcionalidades de criação, edição, exclusão e visualização de tarefas. O projeto foi desenvolvido utilizando Java e Spring Boot, aplicando boas práticas de desenvolvimento de software e o uso de DTOs para a transferência de dados entre as camadas.

## Funcionalidades

- **Criar Tarefas**: Adicione novas tarefas com descrição e status de conclusão.
- **Listar Tarefas**: Visualize todas as tarefas cadastradas no sistema.
- **Editar Tarefas**: Atualize descrições e status das tarefas existentes.
- **Excluir Tarefas**: Remova tarefas da lista.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver a aplicação.
- **Spring Boot**: Framework para facilitar o desenvolvimento de aplicações Java.
- **Hibernate/JPA**: Para mapeamento objeto-relacional (ORM) e persistência de dados.
- **H2 Database**: Banco de dados em memória para testes.
- **DTO (Data Transfer Object)**: Implementação para padronizar a transferência de dados entre as camadas.

## Estrutura do Projeto

- **Controller**: Define as rotas e gerencia as requisições HTTP.
- **Service**: Contém a lógica de negócios e manipulação dos dados.
- **Repository**: Gerencia a interação com o banco de dados.
- **DTO**: Usado para encapsular os dados trafegados entre as camadas.

## Endpoints
- **GET /tasks**: Retorna todas as tarefas.
- **POST /tasks**: Cria uma nova tarefa.
- **PUT /tasks/{id}**: Atualiza uma tarefa existente.
- **DELETE /tasks/{id}**: Remove uma tarefa.


## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.