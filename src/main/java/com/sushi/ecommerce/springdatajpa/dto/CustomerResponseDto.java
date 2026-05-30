package com.sushi.ecommerce.springdatajpa.dto;

import com.sushi.ecommerce.springdatajpa.enums.Role;
import lombok.Data;

@Data
public class CustomerResponseDto {
    private String name;
    private String email;
    private String phone;
    private Role role;
}
