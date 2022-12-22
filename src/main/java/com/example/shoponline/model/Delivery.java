package com.example.shoponline.model;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    @ManyToMany
    @JoinTable(name="delivery_order", joinColumns = @JoinColumn(name="delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "comanda_id"))
    public Set<Order> orders = new HashSet<>();

    @Column(name = "repayment")//ramburs
    public Boolean repayment;

    @OneToOne
    @JoinColumn(name = "user_id")
    public User user;

    public Delivery() {
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Boolean getRepayment() {
        return repayment;
    }

    public void setRepayment(Boolean repayment) {
        this.repayment = repayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Delivery(Set<Order> orders, Boolean repayment, User user) {
        this.orders = orders;
        this.repayment = repayment;
        this.user = user;
    }
}
