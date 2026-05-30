package com.sushi.ecommerce.springdatajpa.repository;

import com.sushi.ecommerce.springdatajpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // JpaRepository provides basic crud methods

    Optional<Product> findByName(String name);
    Optional<Product> findByCategory(String category);
    Optional<Product> findByCompanyName(String companyName);
}
