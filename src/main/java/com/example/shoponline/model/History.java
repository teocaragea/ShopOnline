package com.example.shoponline.model;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {

    public enum Status{
        Preg("In pregatire"),
        Livr("In curs de livrare"),
        Livrat("Livrat");
        public final String label;
        private Status(String label){
            this.label = label;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyId;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "data")
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public History(Delivery delivery, Status status, Date data) {
        this.delivery = delivery;
        this.status = status;
        this.data = data;
    }

    public History() {
    }
}
