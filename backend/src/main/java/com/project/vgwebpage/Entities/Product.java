package com.project.vgwebpage.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, length = 100, nullable = false)
    private String name;
    @Column(nullable = true)
    private String descripString;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = true)
    private Integer rating;
    @Column(nullable=true)
    private String PhotoUrl; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductEnum Type;
    
    //PRODUCT IMAGE AND USER IMAGE AAAAAAAAAAAAAA


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescripString() {
        return descripString;
    }
    public void setDescripString(String descripString) {
        this.descripString = descripString;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }    
    public String getPhotoUrl() {
        return PhotoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }
    public ProductEnum getType() {
        return Type;
    }
    public void setType(ProductEnum type) {
        Type = type;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", descripString=" + descripString + ", amount=" + amount
                + ", rating=" + rating + ", Type=" + Type + "]";
    }
}