package com.sushi.ecommerce.springdatajpa.dto;

import lombok.Data;

@Data
public class ProductUpdateRequestDto {

    private int id;
    private double maxRetailPrice;
    private double discountPercentage;
}
