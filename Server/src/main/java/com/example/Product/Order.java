package com.example.Product;

import com.example.User.User;

public class Order {
    private int orderID;
    private User user;
    private Product product;
    private int quantity;
    private String status;

    public Order(int orderID, User user, Product product, int quantity, String status) {
        this.orderID = orderID;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
