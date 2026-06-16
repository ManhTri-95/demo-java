package com.example.demo.customer;

import com.example.demo.customer.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerResponse create (CreateCustomerRequest req) {
        if (repository.existsByEmail(req.email()))
            throw new IllegalStateException("Email đã tồn tại");
        Customer c = Customer.builder()
                .name (req.name()).email(req.email()).creditLimit(req.creditLimit())
                .build();

        return CustomerResponse.from(repository.save(c));
    }
}