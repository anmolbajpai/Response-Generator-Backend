package com.example.auth.mysql.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "reviewtxt")
    private String reviewtxt;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "ai_reply")
    private String aiReply;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewtxt() {
        return reviewtxt;
    }

    public void setReviewtxt(String reviewtxt) {
        this.reviewtxt = reviewtxt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAiReply() {
        return aiReply;
    }

    public void setAiReply(String aiReply) {
        this.aiReply = aiReply;
    }
}
