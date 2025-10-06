# UserEcho

Projeto de estudo em **arquitetura de microserviços com mensageria assíncrona**, desenvolvido com **Spring Boot (Java 17)** e **RabbitMQ**.  

O sistema demonstra como eventos podem ser utilizados para desacoplar serviços, permitindo comunicação eficiente entre eles.

---

## Arquitetura

![Fluxo do Projeto](<img width="1005" height="216" alt="image" src="https://github.com/user-attachments/assets/e5486d58-1b0a-470b-8390-09967521acf8" />
)

### Fluxo
1. O **cliente** realiza uma requisição `POST /users`.  
2. O **User Microservice**:
   - Salva o usuário no banco de dados.  
   - Publica um evento no **RabbitMQ**.  
3. O **Email Microservice**:
   - Escuta a fila do RabbitMQ.  
   - Envia o e-mail (boas-vindas ou despedida).  
   - Persiste o log do envio no banco de dados.  

---

## Serviços

- **User Microservice**  
  - API REST de usuários.  
  - Publicação de eventos no RabbitMQ.  
  - Banco de dados relacional (PostgreSQL).  

- **Email Microservice**  
  - Consumo de eventos do RabbitMQ.  
  - Envio de e-mails via SMTP.  
  - Persistência dos registros de envio.  

---

## Tecnologias
- **Java 17**  
- **Spring Boot**  
- **Spring Data JPA**  
- **Spring AMQP (RabbitMQ)**  
- **PostgreSQL**  
- **SMTP (para envio de e-mails)**  
- **Docker / Docker Compose** (para subir ambiente com RabbitMQ e banco)  

---

## Objetivo
Este projeto foi desenvolvido com fins **didáticos** para demonstrar:
- Comunicação assíncrona entre microserviços.  
- Uso de **RabbitMQ** como broker de mensagens.  
- Integração entre eventos e envio de notificações.  
- Boas práticas de arquitetura **event-driven** com Spring.  


# Rodar cada microserviço
cd user-service
./mvnw spring-boot:run

cd email-service
./mvnw spring-boot:run
