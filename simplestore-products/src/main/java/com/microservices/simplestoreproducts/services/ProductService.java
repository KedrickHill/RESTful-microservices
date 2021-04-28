package com.microservices.simplestoreproducts.services;

import java.util.List;

import javax.validation.Valid;

import com.microservices.simplestoreproducts.entities.Product;
import com.microservices.simplestoreproducts.managers.ProductManager;
import com.microservices.simplestoreproducts.models.AddProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductManager productManager;
    
    public Product saveProduct(@Valid AddProduct product) {
        return productManager.saveProduct(product);
    }

    public Product getProductById(int id) {
        return productManager.getProductById(id)    ;
    }

    public List<Product> getAllProducts() {
        return productManager.getAllProducts();
    }

    public void deleteProductById(int id) {
        productManager.deleteProductById(id); 
    }

}
