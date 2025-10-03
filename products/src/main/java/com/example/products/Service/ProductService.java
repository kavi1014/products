package com.example.products.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.Entity.Product;
import com.example.products.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productrepository;

    public ProductService(ProductRepository  productrepository) {
        this. productrepository = productrepository;
    }

    public Product saveProduct(Product product) {
        return  productrepository.save(product);
    }

    public List<Product> getAllProducts() {
        return  productrepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return  productrepository.findByCategory(category);
    }
}
