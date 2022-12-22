package com.example.shoponline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "comanda")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comanda_id")
    private int comandaId;

    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(name = "comanda_product", joinColumns = @JoinColumn(name = "comanda_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    Set<Product> products = new HashSet<>();

    public int getComandaId() {
        return comandaId;
    }

    public void setComandaId(int comandaId) {
        this.comandaId = comandaId;
    }

    public Order(){

    }

    public Order(double price, Set<Product> products) {
        this.price = price;
        this.products = products;
    }

    public Order(double price) {
        this.price = price;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
