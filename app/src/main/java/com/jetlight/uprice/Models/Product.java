package com.jetlight.uprice.Models;

public class Product {
    private String name;
    private int price;
    private int imageLink;
    public Product(String name, int price, int imageLink) {
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
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

    public int getImageLink() {
        return imageLink;
    }

    public void setImageLink(int imageLink) {
        this.imageLink = imageLink;
    }
}
