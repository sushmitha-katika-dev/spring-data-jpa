package com.sushi.ecommerce.springdatajpa.model;

import com.sushi.ecommerce.springdatajpa.enums.Gender;
import com.sushi.ecommerce.springdatajpa.enums.Role;
import com.sushi.ecommerce.springdatajpa.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime createdDate;
}
