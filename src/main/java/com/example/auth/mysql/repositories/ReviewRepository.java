package com.example.auth.mysql.repositories;

import com.example.auth.dto.ReviewDetails;
import com.example.auth.mysql.entities.Auth;
import com.example.auth.mysql.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM review WHERE user_id = :user_id", nativeQuery = true)
    List<Review> findByUserId(@Param("user_id") Integer userId);

    @Query(value ="SELECT * FROM review WHERE id = :id", nativeQuery = true)
    Review findById(@Param("id") Integer id);
}
