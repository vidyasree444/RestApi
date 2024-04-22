package com.example.demo.MappingRest.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="category_code")
    private int catCode;
    @Column(name = "category_description")
    private String catDesc;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Products> products;
    public Category() {
    }
    public Category(int catCode, String catDesc, List<Products> products) {
        this.catCode = catCode;
        this.catDesc = catDesc;
        this.products = products;
    }
    public int getCatCode() {
        return catCode;
    }
    public void setCatCode(int catCode) {
        this.catCode = catCode;
    }
    public String getCatDesc() {
        return catDesc;
    }
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }
    public List<Products> getProducts() {
        return products;
    }
    public void setProducts(List<Products> products) {
        this.products = products;
    }
    @Override
    public String toString() {
        return "Category [catCode=" + catCode + ", catDesc=" + catDesc + ", products=" + products + "]";
    }

    

    
}
