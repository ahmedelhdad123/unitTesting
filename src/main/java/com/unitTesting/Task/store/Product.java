package com.unitTesting.Task.store;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public String getName() {
        return name;
    }

    public Product(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product() {
    }
}
