package com.example.shoponline.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

    public enum Type{

        Bratara("Bratara"),
        Lantisor("Lantisor");
        public final String label;
        private Type(String label){
            this.label = label;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name= "type")
    @Enumerated(EnumType.STRING)
    private Type type ;
    @Column(name= "price")
    @Min(0)
    private double price;

    @OneToOne
    @JoinColumn(name = "stone_id")
    @NotNull
    private NaturalStone naturalStone;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public Product(){

    }

    public Product(Type type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type.label;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NaturalStone getNaturalStone() {
        return naturalStone;
    }

    public void setNaturalStone(NaturalStone naturalStone) {
        this.naturalStone = naturalStone;
    }

    public Product(Type type, double price, NaturalStone naturalStone) {
        this.type = type;
        this.price = price;
        this.naturalStone = naturalStone;
    }
}
