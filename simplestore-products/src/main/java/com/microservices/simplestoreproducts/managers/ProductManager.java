package com.microservices.simplestoreproducts.managers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.microservices.simplestoreproducts.entities.Product;
import com.microservices.simplestoreproducts.exceptions.ProductNotFoundException;
import com.microservices.simplestoreproducts.models.AddProduct;
import com.microservices.simplestoreproducts.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductManager {
    
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(@Valid AddProduct product) {
        Product newProduct = new Product(product.getName(), product.getPrice(), product.getDescription());
        productRepository.save(newProduct);
        return newProduct;
    }

    public Product getProductById(int id) {
        Optional<Product> optProduct = productRepository.findById(id);
        if(!optProduct.isPresent()) throw new ProductNotFoundException("Product Not Found");
        return optProduct.get();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(int id) {
        Optional<Product> optProduct = productRepository.findById(id);
        if(!optProduct.isPresent()) throw new ProductNotFoundException("Product Noy Found. Cannot Delete.");
        productRepository.delete(optProduct.get());
    }
}
