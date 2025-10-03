package com.example.products.Controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import com.example.products.Entity.Product;
import com.example.products.Service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {

    private  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   
    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/add")
    public String showAddProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }
    
     @PostMapping("/add")
      public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/display";
    }

    
    @GetMapping("/display")
    public String displayProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "displayProduct";
    }
}
