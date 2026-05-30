package com.sushi.ecommerce.springdatajpa.dto;

import com.sushi.ecommerce.springdatajpa.enums.Gender;
import com.sushi.ecommerce.springdatajpa.enums.Role;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
    private Role role;
}
