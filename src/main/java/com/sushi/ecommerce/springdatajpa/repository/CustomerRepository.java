package com.sushi.ecommerce.springdatajpa.repository;

import com.sushi.ecommerce.springdatajpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /*
    JpaRepository creates basic crud operatins
     */
    //derived operations
    Optional<Customer> findByName(String name);
    Optional<Customer> findByEmail(String email);


}
