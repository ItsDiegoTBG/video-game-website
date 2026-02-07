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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name",unique=true, nullable = false)
    private String name;
    @Column(name = "email",unique=true, nullable = false)
    private String email;
    // add password here? wait isnt that a BAD Idea. We WILL need to hash this later
    @Column(name = "passowrd",unique=true, nullable =false)
    private String password;
    @Column(name = "photo_url",nullable=true)
    private String PhotoUrl; 
    @Column(name= "user_rank",nullable = false)
    @Enumerated(EnumType.STRING)
    private Rank rank;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Rank getRank() {
        return rank;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    public String getPhotoUrl() {
        return PhotoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", rank=" + rank
                + "]";
    }
}
