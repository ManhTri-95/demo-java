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

    public List <CustomerResponse> findAll () {
        return repository.findAll().stream().map(CustomerResponse::from).toList();
    }

    public CustomerResponse findById (Long id) {
        Customer c = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy customer " + id));

        return CustomerResponse.from(c);
    }

    public CustomerResponse update (Long id, CreateCustomerRequest req) {
        Customer c = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy customer " + id));
        c.setName(req.name());
        c.setEmail(req.email());
        c.setCreditLimit(req.creditLimit());
        return CustomerResponse.from(repository.save(c));
    }

    public void delete (Long id) { repository.deleteById(id); }

}