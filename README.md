# Microserviços com Spring Boot + Django + RabbitMQ (Utilizado em Sala de Aula)

Este projeto contém dois microserviços independentes que se comunicam via **mensageria com RabbitMQ**, utilizando filas nomeadas.

## 🧱 Arquitetura

- `accountms`: Microserviço responsável por gerenciar contas de usuários e **enviar mensagens** para a fila `created-customer` via RabbitMQ.
- `notificationms`: Microserviço responsável por **receber mensagens** da fila `created-customer`, armazenar notificações no banco de dados e simular o envio de e-mails.
