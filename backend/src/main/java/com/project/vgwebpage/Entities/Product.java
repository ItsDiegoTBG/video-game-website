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
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",unique = true, length = 100, nullable = false)
    private String name;
    @Column(name = "description",nullable = true,length = 200)
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "amount",nullable = false)
    private Integer amount;
    @Column(name = "rating",nullable = true)
    private Integer rating;
    @Column(name = "photo_url",nullable=true)
    private String PhotoUrl; 
    @Column(name= "product_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType Type;
    
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String descripString) {
        this.description = descripString;
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
    public ProductType getType() {
        return Type;
    }
    public void setType(ProductType type) {
        Type = type;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", descripString=" + description + ", amount=" + amount
                + ", rating=" + rating + ", Type=" + Type + "]";
    }
}