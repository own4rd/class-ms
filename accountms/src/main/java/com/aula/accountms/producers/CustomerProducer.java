package com.aula.accountms.producers;

import com.aula.accountms.dto.response.EmailCustomerDto;
import com.aula.accountms.model.Customer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerProducer {

    final RabbitTemplate rabbitTemplate;



    public CustomerProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.message.name}")
    private String routingKey;

    public void publishMessage(Customer customer) {
        var emailDto = new EmailCustomerDto(
                customer.getId(),
                "Cliente cadastrado com sucesso!",
                "Cliente" + customer.getName() + "cadastrado"
        );

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
