package com.aula.accountms.controller;

import com.aula.accountms.dto.request.CreateCustomerRequestDto;
import com.aula.accountms.dto.response.CustomerResponseDto;
import com.aula.accountms.mapper.CustomerMapper;
import com.aula.accountms.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> save(
            @RequestBody CreateCustomerRequestDto customerDto) {
        var customer = customerMapper.fromCreateDtoToEntity(customerDto);
        customerService.save(customer);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> list() {
         var customers = customerService.findAll();
         var customersDto = customers.stream().map(customerMapper::fromEntityToDto).toList();
         return ResponseEntity.ok(customersDto);
    }
}
