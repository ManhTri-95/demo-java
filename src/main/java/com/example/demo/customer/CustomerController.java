package com.example.demo.customer;

import com.example.demo.customer.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@Valid @RequestBody CreateCustomerRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<CustomerResponse> findAll () {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public  CustomerResponse findById (@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public  CustomerResponse update (@PathVariable Long id, @Valid @RequestBody CreateCustomerRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }
}


