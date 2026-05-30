package com.sushi.ecommerce.springdatajpa.dto;

import lombok.Data;

@Data
public class ProductUpdateRequestDto {

    private int id;
    private String name;
    private String category;
    private String companyName;

}
