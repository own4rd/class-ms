package com.aula.accountms.service;

import com.aula.accountms.model.Customer;
import com.aula.accountms.producers.CustomerProducer;
import com.aula.accountms.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerProducer customerProducer;

    public CustomerService(CustomerRepository customerRepository, CustomerProducer customerProducer) {
        this.customerRepository = customerRepository;
        this.customerProducer = customerProducer;
    }

    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
        customerProducer.publishMessage(customer);

    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
