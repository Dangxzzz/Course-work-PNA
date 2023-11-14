package com.example.Review;

import com.example.Product.Product;
import com.example.User.User;

public class Review {
    private int reviewID;
    private User user;
    private Product product;
    private int rating;
    private String comment;

    public Review(int reviewID, User user, Product product, int rating, String comment) {
        this.reviewID = reviewID;
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
    }

    public int getReviewID() {
        return reviewID;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}