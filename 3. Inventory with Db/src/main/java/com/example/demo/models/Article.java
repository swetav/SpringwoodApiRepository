package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //This will create the article table in our DB
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;
    private  int price;
    private String description;
    private boolean madeInIndia = true; //true if made in India and false otherwise

    public Article() { // Default constructor. Takes no arguments
    }

    public Article(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Article(String name, int price, String description, boolean madeInIndia) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.madeInIndia = madeInIndia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMadeInIndia() {
        return madeInIndia;
    }

    public void setMadeInIndia(boolean madeInIndia) {
        this.madeInIndia = madeInIndia;
    }
}
