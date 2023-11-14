package com.example.Product;

public class Product {
    private int productID;
    private String productName;
    private int stockQuantity;

    public Product(int productID, String productName, int stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.stockQuantity = stockQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int quantity) {
        this.stockQuantity = quantity;
    }
}
