package com.example.Jewelry.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class JewelryGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String metal;
    private String gemstone;
    private Float price;

    public JewelryGroup (String metal, String gemstone, Float price){
        this.metal = metal;
        this.gemstone = gemstone;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getGemstone() {
        return gemstone;
    }

    public void setGemstone(String gemstone) {
        this.gemstone = gemstone;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
