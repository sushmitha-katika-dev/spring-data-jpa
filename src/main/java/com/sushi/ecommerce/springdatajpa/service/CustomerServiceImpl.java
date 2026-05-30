package com.sushi.ecommerce.springdatajpa.service;

import com.sushi.ecommerce.springdatajpa.dto.CustomerResponseDto;
import com.sushi.ecommerce.springdatajpa.dto.CustomerUpdateRequestDto;
import com.sushi.ecommerce.springdatajpa.dto.CustomerRequestDto;
import com.sushi.ecommerce.springdatajpa.enums.Status;
import com.sushi.ecommerce.springdatajpa.exception.CustomerExitsException;
import com.sushi.ecommerce.springdatajpa.exception.CustomerNotFoundException;
import com.sushi.ecommerce.springdatajpa.model.Customer;
import com.sushi.ecommerce.springdatajpa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) throws CustomerExitsException {
        // 1. check if product exists
        //2. throw exception if exists
        customerRepository.findById( customerRequestDto.getId()).ifPresent(c -> {
            throw new CustomerExitsException("Customer already exists with name: " + customerRequestDto.getId());
        });

        // DTO → Entity

        Customer customer = modelMapper.map(customerRequestDto, Customer.class );
        customer.setCreatedDate(LocalDateTime.now());
        customer.setStatus(Status.ACTIVE);
        // Entity → DTO
        return modelMapper.map(customerRepository.save(customer), CustomerResponseDto.class);

    }

    @Override
    public CustomerResponseDto getById(int id) throws CustomerNotFoundException {
        return modelMapper.map(customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id)),CustomerResponseDto.class);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        return customerRepository.findAll().stream().map(c -> modelMapper.map(c, CustomerResponseDto.class)).toList();
    }

    @Override
    public CustomerResponseDto update(CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException {
        Customer existingCustomer = customerRepository.findById(
                        customerUpdateRequestDto.getId())
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found with id: "
                                        + customerUpdateRequestDto.getId()));

        existingCustomer.setName(customerUpdateRequestDto.getName());
        existingCustomer.setEmail(customerUpdateRequestDto.getEmail());
        existingCustomer.setPassword(customerUpdateRequestDto.getPassword());
        existingCustomer.setPhone(customerUpdateRequestDto.getPhone());
        existingCustomer.setGender(customerUpdateRequestDto.getGender());
        return modelMapper.map(customerRepository.save(existingCustomer),CustomerResponseDto.class);
    }

    @Override
    public void delete(int id) throws CustomerNotFoundException {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
        customerRepository.deleteById(id);
    }

}
