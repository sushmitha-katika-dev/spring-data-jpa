# Spring Data JPA E-Commerce API

A Spring Boot REST API demonstrating CRUD operations using Spring Data JPA with Product and Customer management modules.

## Features

* Spring Boot
* Spring Data JPA
* MySQL Database
* Product Management CRUD
* Customer Management CRUD
* DTO Pattern
* ModelMapper Integration
* Custom Exceptions
* Global Exception Handling
* Layered Architecture

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Lombok
* ModelMapper
* Maven

## Modules

### Product Module

Supports:

* Create Product
* Get Product By Id
* Get All Products
* Update Product
* Delete Product

### Customer Module

Supports:

* Create Customer
* Get Customer By Id
* Get All Customers
* Update Customer
* Delete Customer

## Project Structure

```text
src/main/java
├── controller
│   ├── ProductController
│   └── CustomerController
├── service
├── repository
├── model
├── dto
├── exception
└── config
```

## Concepts Practiced

* Spring Data JPA Repositories
* Entity Mapping
* DTO Request and Response Objects
* ModelMapper Object Conversion
* Custom Exceptions
* Global Exception Handling using @ControllerAdvice
* Dependency Injection
* Service Layer Design
* REST API Development

## Learning Outcomes

This project was developed to learn Spring Boot and Spring Data JPA fundamentals, including CRUD operations, DTO-based communication, object mapping with ModelMapper, and centralized exception handling for scalable REST APIs.
