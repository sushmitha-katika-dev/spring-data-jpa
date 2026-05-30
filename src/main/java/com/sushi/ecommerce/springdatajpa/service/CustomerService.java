package com.sushi.ecommerce.springdatajpa.service;

import com.sushi.ecommerce.springdatajpa.dto.CustomerResponseDto;
import com.sushi.ecommerce.springdatajpa.dto.CustomerUpdateRequestDto;
import com.sushi.ecommerce.springdatajpa.dto.CustomerRequestDto;
import com.sushi.ecommerce.springdatajpa.exception.CustomerExitsException;
import com.sushi.ecommerce.springdatajpa.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto save(CustomerRequestDto customerRequestDto) throws CustomerExitsException;

    CustomerResponseDto getById(int id) throws CustomerNotFoundException;

    List<CustomerResponseDto> getAll();

    CustomerResponseDto update(CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException;

    void delete(int id) throws CustomerNotFoundException;
}
