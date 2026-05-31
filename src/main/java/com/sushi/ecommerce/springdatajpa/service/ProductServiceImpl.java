package com.sushi.ecommerce.springdatajpa.service;

import com.sushi.ecommerce.springdatajpa.dto.ProductRequestDto;
import com.sushi.ecommerce.springdatajpa.dto.ProductResponseDto;
import com.sushi.ecommerce.springdatajpa.dto.ProductUpdateRequestDto;
import com.sushi.ecommerce.springdatajpa.exception.ProductExistsException;
import com.sushi.ecommerce.springdatajpa.exception.ProductNotFoundException;
import com.sushi.ecommerce.springdatajpa.model.Product;
import com.sushi.ecommerce.springdatajpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Override
    public ProductResponseDto save(ProductRequestDto productRequestDto) throws ProductExistsException {
        productRepository.findById(productRequestDto.getId())
                .ifPresent(p -> {
                    throw new ProductExistsException("Product with id " + p.getId() + " already exists");
        });
        //Dto to Entity
        Product product = modelMapper.map(productRequestDto,Product.class);

        // Entity → DTO
        return modelMapper.map(productRepository.save(product),ProductResponseDto.class);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream().map(p -> modelMapper.map(p,ProductResponseDto.class)).toList();
    }

    @Override
    public ProductResponseDto getById(int id) throws ProductNotFoundException {
        return modelMapper.map(productRepository.findById(id)
                .orElseThrow(() ->
                    new ProductNotFoundException("Product with id " + id + " not found")),ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto update(ProductUpdateRequestDto productUpdateRequestDto) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(productUpdateRequestDto.getId())
                .orElseThrow(() ->
                    new ProductNotFoundException("Product with id " + productUpdateRequestDto.getId() + " not found"));

        existingProduct.setMaxRetailPrice(productUpdateRequestDto.getMaxRetailPrice());
        existingProduct.setDiscountPercentage(productUpdateRequestDto.getDiscountPercentage());
        return modelMapper.map(productRepository.save(existingProduct),ProductResponseDto.class);
    }

    @Override
    public void delete(int id) throws ProductNotFoundException {
        productRepository.findById(id)
                .orElseThrow(() ->
                    new ProductNotFoundException("Product with id " + id + " not found"));
        productRepository.deleteById(id);
    }
}
