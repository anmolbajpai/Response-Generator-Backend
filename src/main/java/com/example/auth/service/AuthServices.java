package com.example.auth.service;

import com.example.auth.dto.*;
import com.example.auth.mysql.entities.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthServices {
    void registerUser(SignupDetails signupDetails);
    LoginResponse loginUser(LoginDetails loginDetails) throws Exception;
    ResponseEntity<UserResponse> getUser(String token);
    String addReview(ReviewDetails reviewDetails, String token);
    List<Review> getReviews(String token);
    String addAiReply(ReplyDetails replyDetails, String token);
}
