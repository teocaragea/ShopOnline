package com.example.shoponline.controller;

import com.example.shoponline.model.Product;
import com.example.shoponline.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> retrieveProducts(){
        return ResponseEntity.ok().body(productService.retrieveProducts());
    }

    @PostMapping("/adauga")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.addProduct(product));
    }

}
