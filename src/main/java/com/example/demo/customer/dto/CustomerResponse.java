package com.example.demo.customer.dto;

import com.example.demo.customer.Customer;
import java.math.BigDecimal;
import java.time.Instant;

public record CustomerResponse (
        Long id, String name, String email, BigDecimal createLimit, Instant createAt
) {
    public static CustomerResponse from (Customer c) {
        return new CustomerResponse(c.getId(), c.getName(), c.getEmail(), c.getCreditLimit(), c.getCreatedAt());
    }
}