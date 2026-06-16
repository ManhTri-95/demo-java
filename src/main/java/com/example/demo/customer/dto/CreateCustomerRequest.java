package com.example.demo.customer.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateCustomerRequest (
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotNull @DecimalMin("0.0") BigDecimal creditLimit
) {}