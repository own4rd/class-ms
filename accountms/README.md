# Account Microservice 👤

Este microserviço é responsável por gerenciar contas de usuários e **enviar notificações para outros microserviços** (como o `notificationms`) através de mensagens publicadas no **RabbitMQ**.

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- RabbitMQ (via CloudAMQP)
- Maven ou Gradle

---

## 📦 Configuração do RabbitMQ (CloudAMQP)

No arquivo `application.yaml`, configure o acesso ao broker:

```yaml
spring:
  rabbitmq:
    addresses: your_link
```