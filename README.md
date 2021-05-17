# API Todo

# Sobre
O projeto trata-se de uma API REST para o gerenciamento de tarefas

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Banco de dados: Postgresql

# Como executar o projeto

## Banco de dados

```postgresql
# criar a base de dados no postgreSql conforme a ddl a seguir
CREATE DATABASE java_api_todo
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
```

## Back end
Pré-requisitos: Java 8

```bash
# clonar repositório
git clone https://github.com/andersonFb/todo_application.git

# entrar na pasta do projeto back end
cd todo_application

# executar o projeto
./mvnw spring-boot:run
```

## Endpoints
### Endpoint para GET E POST
- /api/tarefas
### Endpoint para GET, PUT e DELETE
- /api/tarefas/{id}
### Endpoint para Filtro padrão
- /api/tarefas/page
### Endpoint para Filtro com parâmetros
- /api/tarefas/page?sort=createdAt

# Autor

Anderson Fonseca

https://www.linkedin.com/in/anderson-fonseca-developer
