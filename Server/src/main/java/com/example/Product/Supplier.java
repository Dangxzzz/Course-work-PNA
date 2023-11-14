package com.example.Product;

public class Supplier {
    private int supplierID;
    private String supplierName;
    private int locationID;

    public Supplier(int supplierID, String supplierName, int locationID) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.locationID = locationID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public int getLocationID() {
        return locationID;
    }
}
