# Notification Microservice 📬

Este microserviço é responsável por **receber notificações de outros sistemas via fila RabbitMQ**, processá-las e **armazená-las no banco de dados**, além de simular o envio de e-mails de confirmação para os usuários.

## 🔧 Requisitos

- Python 3.10+
- RabbitMQ
- Django
- Celery

---

### Lembre-se de em settings.py colocar seu link do broker

## 🚀 Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/notificationms.git
cd notificationms
```

### 2. Crie ambiente virtual

``` shell
python -m venv venv
source venv/bin/activate  # Linux/macOS
venv\Scripts\activate     # Windows
```

### 3. Instalar dependências

```shell
pip install -r requirements.txt
```

### 4. Rodar Migrations
```shell
python manage.py migrate
```

### 5. Rodando Servidor
```shell
python manage.py runserver
```

### 6. Rodar worker do celery
```shell
celery -A notificationms worker --loglevel=info -Q created-customer
```
