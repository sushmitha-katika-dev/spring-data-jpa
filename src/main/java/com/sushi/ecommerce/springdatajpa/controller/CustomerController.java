package com.sushi.ecommerce.springdatajpa.controller;

import com.sushi.ecommerce.springdatajpa.dto.CustomerResponseDto;
import com.sushi.ecommerce.springdatajpa.dto.CustomerUpdateRequestDto;
import com.sushi.ecommerce.springdatajpa.dto.CustomerRequestDto;
import com.sushi.ecommerce.springdatajpa.exception.CustomerNotFoundException;
import com.sushi.ecommerce.springdatajpa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> save(@RequestBody CustomerRequestDto customerRequestDto) throws CustomerNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PutMapping
    public ResponseEntity<CustomerResponseDto> update(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.update(customerUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
