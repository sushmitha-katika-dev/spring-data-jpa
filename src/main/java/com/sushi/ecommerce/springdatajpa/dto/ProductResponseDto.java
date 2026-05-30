package com.sushi.ecommerce.springdatajpa.dto;

import lombok.Data;

@Data
public class ProductResponseDto {

    private String id;
    private String name;
    private String category;
    private String companyName;
    private String manufacturedYear;
}
