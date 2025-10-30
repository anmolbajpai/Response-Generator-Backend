package com.example.auth.controller;
import com.example.auth.dto.*;
import com.example.auth.mysql.entities.Review;
import com.example.auth.service.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//public class AuthController {
//    AuthServices AuthServicesImpl;
//
//    @PostMapping("/signup")
//    String signup(@RequestBody SignupDetails signupDetails){
//        AuthServicesImpl.registerUser(signupDetails);
//        return "register successfully";
//    }
//}
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthServices authServicesImpl;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupDetails signupDetails) {
        authServicesImpl.registerUser(signupDetails);
        return "register successfully";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginDetails loginDetails) throws Exception {
        LoginResponse loginResponse = authServicesImpl.loginUser(loginDetails);
        return loginResponse;

    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUser(@RequestHeader("Authorization") String token){
        // The common convention is to pass the token as "Bearer [token]".
        // We typically strip the "Bearer " prefix before passing it to the service.
        System.out.println(token);
        return authServicesImpl.getUser(token);
    }
    
    @PostMapping("/add-review")
    public String addReview(@RequestBody ReviewDetails reviewResponse, @RequestHeader("Authorization") String token){
        return authServicesImpl.addReview(reviewResponse, token);
    }

    @GetMapping("/get-reviews")
    public List<Review> getReviews(@RequestHeader("Authorization") String token){
        return authServicesImpl.getReviews(token);
    }

    @PostMapping("add-reply")
    public String addAiReply(@RequestBody ReplyDetails replyDetails, @RequestHeader("Authorization") String token){
        return authServicesImpl.addAiReply(replyDetails, token);
    }
}

