package com.example.demo.customer;

import com.example.demo.customer.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService service;


}


