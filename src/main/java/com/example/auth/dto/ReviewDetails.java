package com.example.auth.dto;

public class ReviewDetails {

    private String customerName;
    private Integer rating;
    private String reviewTaxt;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewTaxt() {
        return reviewTaxt;
    }

    public void setReviewTaxt(String reviewTaxt) {
        this.reviewTaxt = reviewTaxt;
    }
}
