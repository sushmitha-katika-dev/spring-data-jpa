package com.sushi.ecommerce.springdatajpa.dto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private int id;
    private String name;
    private double maxRetailPrice;
    private double discountPercentage;
    private String category;
    private String companyName;
    private String manufacturedYear;
}
