package com.example.Product;

public class Product {
    private int productID;
    private String productName;
    private int stockQuantity;
    private int supplierID;

    public Product(int productId, String productName, int stockQuantity, int supplierId) {
        this.productID = productId;
        this.productName = productName;
        this.stockQuantity = stockQuantity;
        this.supplierID = supplierId;
    }
    public Product(String productName, int stockQuantity, int supplierId) {
        this.productName = productName;
        this.stockQuantity = stockQuantity;
        this.supplierID = supplierId;
    }

    // Добавим геттеры

    public int getSupplierID() {
        return supplierID;
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
