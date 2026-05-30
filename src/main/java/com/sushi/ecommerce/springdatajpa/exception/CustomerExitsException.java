package com.sushi.ecommerce.springdatajpa.exception;

public class CustomerExitsException extends RuntimeException{
    public CustomerExitsException(String message) {
        super(message);
    }
}
