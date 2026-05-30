package com.sushi.ecommerce.springdatajpa.dto;

import com.sushi.ecommerce.springdatajpa.enums.Gender;
import lombok.Data;

@Data
public class CustomerUpdateRequestDto {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
}
