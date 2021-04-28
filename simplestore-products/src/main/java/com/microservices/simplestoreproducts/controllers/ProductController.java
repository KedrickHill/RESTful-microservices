package com.microservices.simplestoreproducts.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.microservices.simplestoreproducts.entities.Product;
import com.microservices.simplestoreproducts.models.AddProduct;
import com.microservices.simplestoreproducts.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> showProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody AddProduct product) {
        Product savedProduct = productService.saveProduct(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/products/{id}")
    public Product showOneProduct(@PathVariable int id) {
        return productService.getProductById(id);

    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return "Product Deleted!";
    }
}
