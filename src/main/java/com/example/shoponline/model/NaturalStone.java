package com.example.shoponline.model;

import javax.persistence.*;

@Entity
@Table(name = "stones")
public class NaturalStone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stoneId;
    private String description;
    private String name;

    public NaturalStone(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public NaturalStone(){

    }

    public int getStoneId() {
        return stoneId;
    }

    public void setStoneId(int piatraId) {
        this.stoneId = piatraId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
