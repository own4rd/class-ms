package com.aula.accountms.mapper;

import com.aula.accountms.dto.request.CreateCustomerRequestDto;
import com.aula.accountms.dto.response.CustomerResponseDto;
import com.aula.accountms.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer fromCreateDtoToEntity(CreateCustomerRequestDto customerRequestDto) {
        return new Customer(
                customerRequestDto.password(),
                customerRequestDto.name(),
                customerRequestDto.email(),
                customerRequestDto.mobileNumber()
        );
    }

    public CustomerResponseDto fromEntityToDto(Customer customer) {
        return new CustomerResponseDto(
                customer.getId(),
                customer.getEmail(),
                customer.getName()
        );
    }
}

