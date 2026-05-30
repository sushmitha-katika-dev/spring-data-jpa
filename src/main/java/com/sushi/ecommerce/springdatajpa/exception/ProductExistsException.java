package com.sushi.ecommerce.springdatajpa.exception;

public class ProductExistsException extends RuntimeException{
    public ProductExistsException(String message) {
        super(message);
    }
}
