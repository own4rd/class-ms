from celery import shared_task
import logging
from notifications.models import Notification  # ajuste o import conforme o nome do app

logger = logging.getLogger(__name__)

@shared_task(name='created_customer_task', queue='created-customer')
def created_customer_task(message):
    user_id = message.get('userId')
    subject = message.get('subject')
    text = message.get('text')

    logger.warning("Enviando e-mail de confirmação de cadastro...")
    logger.warning(f"Para o usuário ID: {user_id}")
    logger.warning(f"Assunto: {subject}")
    logger.warning(f"Conteúdo:")
    logger.warning(text)
    logger.warning("E-mail enviado com sucesso!")

    # Salvando no banco
    Notification.objects.create(
        title=subject,
        message=text
    )
