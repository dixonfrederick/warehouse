// ProductService.java
package com.example.warehouse.service;

import com.example.warehouse.model.Product;
import com.example.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProductQuantity(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setQuantity(product.getQuantity() + quantity);
        return productRepository.save(product);
    }

    public Product borrowProduct(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough inventory");
        }
        product.setQuantity(product.getQuantity() - quantity);
        product.setBorrowed(product.getBorrowed() + quantity);
        return productRepository.save(product);
    }

    public Product returnProduct(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        if (product.getBorrowed() < quantity) {
            throw new RuntimeException("Not enough borrowed products");
        }
        product.setQuantity(product.getQuantity() + quantity);
        product.setBorrowed(product.getBorrowed() - quantity);
        return productRepository.save(product);
    }
}