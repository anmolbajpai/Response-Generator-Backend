package com.example.auth.service.Impl;

import com.example.auth.dto.*;
import com.example.auth.mysql.entities.Auth;
import com.example.auth.mysql.entities.Review;
import com.example.auth.mysql.repositories.AuthRepository;
import com.example.auth.mysql.repositories.ReviewRepository;
import com.example.auth.service.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServicesImpl implements AuthServices {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void registerUser(SignupDetails signupDetails) {
        Auth auth = new Auth();
        auth.setName(signupDetails.getUsername());
        auth.setEmail(signupDetails.getEmail());
        auth.setPassword(signupDetails.getPassword());
        authRepository.save(auth);
    }

    @Override
    public LoginResponse loginUser(LoginDetails loginDetails) throws Exception {
        Optional<Auth> auth = authRepository.findByEmail(loginDetails.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        if (auth.isEmpty()) {
            loginResponse.setMessage("user doesn't exist");
            return loginResponse;
        }
        Auth foundAuth = auth.get();

        if (!Objects.equals(loginDetails.getPassword(), foundAuth.getPassword())) {
            loginResponse.setMessage("password id incorrect");
            return loginResponse;
        }

        Random random = new Random();
        String token = String.format("%05d", random.nextInt(100000));
        foundAuth.setToken(token);
        authRepository.save(foundAuth);

        loginResponse.setToken(token);
        loginResponse.setMessage("login successfully");

        return loginResponse;
    }

    @Override
    public ResponseEntity<UserResponse> getUser(String token) {
        Optional<Auth> auth = authRepository.findByToken(token);
        UserResponse userResponse = new UserResponse();

        if (auth.isEmpty()) {
            userResponse.setMessage("wrong token");
            return new ResponseEntity<>(userResponse, HttpStatus.FORBIDDEN);
        }

        userResponse.setUsername(auth.get().getName());
        userResponse.setMessage("user is logged in");
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @Override
    public String addReview(ReviewDetails reviewDetails, String token) {
        Optional<Auth> auth = authRepository.findByToken(token);
        if (auth.isEmpty()) {
            return "wrong token";
        }

        Review review = new Review();
        review.setUserId(auth.get().getId());
        review.setName(reviewDetails.getCustomerName());
        review.setRating(reviewDetails.getRating());
        review.setReviewtxt(reviewDetails.getReviewTaxt());
        reviewRepository.save(review);
        return "review added successfully ";
    }


    @Override
    public List<Review> getReviews(String token) {
        Optional<Auth> auth = authRepository.findByToken(token);
        if (auth.isEmpty()) {
            return Collections.emptyList(); // or throw exception
        }
        return reviewRepository.findByUserId(auth.get().getId());
    }

    @Override
    public String addAiReply(ReplyDetails replyDetails, String token){
        Optional<Auth> auth = authRepository.findByToken(token);
        if (auth.isEmpty()) {
            return "Login yourself" ;
        }
        Review review = reviewRepository.findById(replyDetails.getId());
        if(review == null){
            return "feedback not found";
        }
        review.setAiReply(replyDetails.getReply());
        reviewRepository.save(review);
        return "aiReply save successfully";
    }

}