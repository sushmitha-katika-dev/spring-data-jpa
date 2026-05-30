package com.sushi.ecommerce.springdatajpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double maxRetailPrice;
    private double discountPercentage;
    private String category;
    private String companyName;
    private String manufacturedYear;
}
