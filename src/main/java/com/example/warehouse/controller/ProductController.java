// ProductController.java
package com.example.warehouse.controller;

import com.example.warehouse.model.Product;
import com.example.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("/{id}/increase") // Increase products
    public Product increaseProductQuantity(@PathVariable Long id, @RequestParam int quantity) {
        return productService.updateProductQuantity(id, quantity);
    }

    @PutMapping("/{id}/borrow") // Borrow products
    public Product borrowProduct(@PathVariable Long id, @RequestParam int quantity) {
        return productService.borrowProduct(id, quantity);
    }

    @PutMapping("/{id}/return")  // Return products
    public Product returnProduct(@PathVariable Long id, @RequestParam int quantity) {
        return productService.returnProduct(id, quantity);
    }
}