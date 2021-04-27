package com.microservices.simplestoreproducts;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Product saveProduct(@Valid Product product) {
        return null;
    }

    public Product getProductById(int id) {
        Optional<Product> optProduct = productRepository.findById(id);
        if(!optProduct.isPresent()) throw new ProductNotFoundException("Product Not Found");
        return optProduct.get();
    }

}
