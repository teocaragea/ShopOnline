package com.example.shoponline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comanda")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comanda_id")
    private int comandaId;

    @Column(name = "price")
    private double price;

    @OneToMany
    @JoinColumn(name = "product_id")
    List<Product> products = new ArrayList<>();

    public Order(){

    }

    public Order(double price, List<Product> products) {
        this.price = price;
        this.products = products;
    }

    public double getPrice() {
        return price;
    }

    public int getOrdersId() {
        return comandaId;
    }

    public void setOrdersId(int orderId) {
        this.comandaId = orderId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
