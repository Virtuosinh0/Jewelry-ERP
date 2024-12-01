package com.example.Jewelry.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String metal;
    private String gemstone;
    private Float supplierprice;
    private Float processprice = 0.0F;
    private Float profit = 0.0F;
    private Float price;
    private Boolean Sold = false;
    private Boolean toSell = false;

    public Boolean getToSell() {
        return toSell;
    }

    public void setToSell(Boolean toSell) {
        this.toSell = toSell;
    }

    public Boolean getSold() {
        return Sold;
    }

    public void setSold(Boolean sold) {
        Sold = sold;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.supplierprice = this.price;
        this.price = price;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        // Se não tem preço de processamento, verifica o preço de fornededor
        if (this.processprice == null || this.processprice.isNaN()) {
                this.profit = profit;
                this.price = this.supplierprice + profit;
        } else  { // Se tem preço de processo, soma preço de fornecedor, processo e lucro no preço do cliente
            this.profit = profit;
            this.price = this.supplierprice + this.processprice + profit;
        }
    }

    public Float getProcessprice() {
        return processprice;
    }

    public void setProcessprice(Float processprice) {
        this.processprice = processprice;
    }

    public Float getSupplierprice() {
        return supplierprice;
    }

    public void setSupplierprice(Float supplierprice) {
        this.supplierprice = supplierprice;
    }

    public String getGemstone() {
        return gemstone;
    }

    public void setGemstone(String gemstone) {
        this.gemstone = gemstone;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }
}


