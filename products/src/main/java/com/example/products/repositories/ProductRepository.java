package com.example.products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.products.Entity.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    List<Product> findByCategory(String category); 
}
