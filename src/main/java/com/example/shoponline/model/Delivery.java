package com.example.shoponline.model;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    @OneToMany
    @JoinColumn(name = "comanda_id")
    public List<Order> orders = new ArrayList<>();

    @Column(name = "repayment")//ramburs
    public Boolean repayment;

    @OneToOne
    @JoinColumn(name = "user_id")
    public User user;

    public Delivery() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
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

    public Delivery(List<Order> orders, Boolean repayment, User user) {
        this.orders = orders;
        this.repayment = repayment;
        this.user = user;
    }
}
