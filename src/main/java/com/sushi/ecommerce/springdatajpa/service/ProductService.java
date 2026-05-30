package com.sushi.ecommerce.springdatajpa.service;

import com.sushi.ecommerce.springdatajpa.dto.ProductRequestDto;
import com.sushi.ecommerce.springdatajpa.dto.ProductResponseDto;
import com.sushi.ecommerce.springdatajpa.dto.ProductUpdateRequestDto;
import com.sushi.ecommerce.springdatajpa.exception.ProductExistsException;
import com.sushi.ecommerce.springdatajpa.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductResponseDto save(ProductRequestDto productRequestDto) throws ProductExistsException;
    List<ProductResponseDto> getAll();
    Optional<ProductResponseDto> getById(int id) throws ProductNotFoundException;
    ProductResponseDto update(ProductUpdateRequestDto productUpdateRequestDto) throws ProductNotFoundException;
    void delete(int id) throws ProductNotFoundException;
}
