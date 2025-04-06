import os
from celery import Celery
from kombu import Queue

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'notificationms.settings')

app = Celery('notificationms')

app.config_from_object('django.conf:settings', namespace='CELERY')

app.conf.task_queues = (
    Queue('created-customer'),
)

app.autodiscover_tasks()
