package com.example.demo.MappingRest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int prodId;
    @Column(name = "product_name")
    private String prodName;
    @Column(name = "quantity")
    private int qty;
    @Column(name = "price")
    private Long price;

     @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "catCode")
    private Category category;

    public Products() {
    }

    public Products(int prodId, String prodName, int qty, Long price, Category category) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.qty = qty;
        this.price = price;
        this.category = category;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Products [prodId=" + prodId + ", prodName=" + prodName + ", qty=" + qty + ", price=" + price
                + ", category=" + category + "]";
    }

    
}
