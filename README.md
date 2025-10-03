# UserEcho

Este projeto demonstra a implementação de **microserviços com mensageria assíncrona**, utilizando **RabbitMQ** e **Spring Boot (Java 17)**.

A aplicação é composta por dois serviços principais:

* **User Microservice**

  * Expõe uma **API REST** para operações de usuários (criação, atualização, exclusão).
  * Cada ação gera um **evento** que é publicado em uma **fila no RabbitMQ**.

* **Notification (Email) Microservice**

  * Consome os eventos do RabbitMQ.
  * Envia notificações por **e-mail via SMTP**, como mensagens de boas-vindas ao criar um usuário ou de despedida ao deletar.

### Tecnologias

* Java 17
* Spring Boot
* Spring AMQP (RabbitMQ)
* Spring Data JPA
* PostgreSQL (ou outro banco relacional configurável)
* SMTP (para envio de e-mails)

### Objetivo

O projeto tem caráter **didático** e foi desenvolvido para praticar conceitos de:

* Arquitetura de microserviços.
* Comunicação assíncrona com mensageria (RabbitMQ).
* Integração entre serviços através de eventos.
* Envio de notificações automatizadas por e-mail.

### Fluxo Resumido

1. O cliente consome a **API REST do User Service**.
2. O User Service publica uma mensagem no **RabbitMQ** referente à ação realizada.
3. O Notification Service consome a mensagem e envia um **e-mail** correspondente.

---
