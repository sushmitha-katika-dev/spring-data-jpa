package com.sushi.ecommerce.springdatajpa.controller;

import com.sushi.ecommerce.springdatajpa.dto.ProductRequestDto;
import com.sushi.ecommerce.springdatajpa.dto.ProductResponseDto;
import com.sushi.ecommerce.springdatajpa.dto.ProductUpdateRequestDto;
import com.sushi.ecommerce.springdatajpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> save(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PutMapping
    public ResponseEntity<ProductResponseDto> update(@RequestBody ProductUpdateRequestDto  productUpdateRequestDto){
        return ResponseEntity.ok(productService.update(productUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
