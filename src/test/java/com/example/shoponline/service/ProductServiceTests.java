package com.example.shoponline.service;

import com.example.shoponline.model.Product;
import com.example.shoponline.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {
    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    @DisplayName("Retrieve all products")
    void testRetrieveProducts(){
        Product product = new Product();
        product.setType(Product.Type.Bratara);
        List<Product> products = new ArrayList<>();
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);

        List<Product> results = productService.retrieveProducts();

        assertEquals(results.size(), products.size());
    }

    @Test
    @DisplayName("Save new product")
    void testAddProduct(){
        Product product = new Product();
        product.setType(Product.Type.Bratara);
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.addProduct(product);

        assertEquals(result.getType(), product.getType());
    }
}
