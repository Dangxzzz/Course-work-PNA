package com.example.Product;

public class DeliveryLocation {
    private int locationID;
    private String locationName;
    private String address;

    public DeliveryLocation(int locationID, String locationName, String address) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.address = address;
    }

    public int getLocationID() {
        return locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getAddress() {
        return address;
    }
}
