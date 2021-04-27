package com.microservices.simplestoreproducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts() {
        return "List of Products Here";
    }

    // @PostMapping("/products")
    // public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product) {
    //     Product savedProduct = productService.saveProduct(product);
    //     URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.getId()).toUri();
    //     return ResponseEntity.created(location).build();
    // }

    @GetMapping("/products/{id}")
    public Product showOneProduct(@PathVariable int id) {
        return productService.getProductById(id);

    }
}
