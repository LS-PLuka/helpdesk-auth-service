# 🔐 Helpdesk Auth Service

Microsserviço responsável pela autenticação e autorização da plataforma Helpdesk, centralizando o controle de usuários, geração de JWT e permissões (USER e ADMIN).

Este serviço é a base de segurança do sistema e deve ser o primeiro a ser iniciado.

---

## 📌 Responsabilidades

- Cadastro de usuários
- Login e autenticação
- Geração de token JWT
- Validação de permissões
- Publicação de eventos para outros microsserviços

---

## 🧱 Tecnologias Utilizadas

- Java 21+
- Spring Boot
- Spring Security
- OAuth2 Resource Server (JWT)
- Spring Data JPA
- PostgreSQL
- RabbitMQ (Spring AMQP)
- Springdoc OpenAPI (Swagger)
- Docker

---

## 🗄️ Banco de Dados

Banco utilizado: PostgreSQL

### Tabela: auth_users

Campos:
- id (UUID)
- email
- password
- role (USER ou ADMIN)

Cada microsserviço da plataforma possui seu próprio banco de dados, garantindo isolamento e independência.

---

## 🔁 Integração com RabbitMQ

Este serviço publica eventos para notificar outros microsserviços sobre a criação de usuários.

Evento publicado:
- user.created

Esse evento é consumido pelo microsserviço de usuários para criação do perfil do usuário no sistema.

---

## 🔐 Endpoints Disponíveis

- POST /auth/register  
  Responsável pelo cadastro de novos usuários

- POST /auth/login  
  Responsável pela autenticação e geração do token JWT

- GET /auth/validate  
  Responsável pela validação do token e permissões

---

## 🔑 Autenticação e Segurança

- Autenticação baseada em JWT
- O token deve ser enviado no header Authorization
- Controle de acesso baseado em roles (USER e ADMIN)
- As senhas são armazenadas de forma criptografada
- Nenhum outro microsserviço tem acesso às credenciais

---

## 📄 Documentação (Swagger)

Cada microsserviço da plataforma expõe sua própria documentação OpenAPI.

No Auth Service, a documentação permite:
- Visualizar todos os endpoints
- Entender os contratos de entrada e saída
- Testar as requisições autenticadas

---

## 🐳 Docker

Este serviço é executado em ambiente Docker, fazendo parte de uma arquitetura baseada em Docker Compose junto aos demais microsserviços da plataforma Helpdesk.

---

## 📍 Porta Padrão

- Auth Service: 8081

---

## 📎 Observações Importantes

- Este serviço deve ser iniciado antes dos demais
- Nenhum outro serviço cria usuários diretamente
- A autenticação é centralizada neste microsserviço
- A comunicação entre serviços é desacoplada via RabbitMQ
- Arquitetura real, orientada a eventos e boas práticas

---

## 📚 Ecossistema Helpdesk

- helpdesk-auth-service
- helpdesk-user-service
- helpdesk-request-service
- helpdesk-notification-service
