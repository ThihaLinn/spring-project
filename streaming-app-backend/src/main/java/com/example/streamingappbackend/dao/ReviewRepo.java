package com.example.streamingappbackend.dao;

import com.example.streamingappbackend.entity.Review;
import com.example.streamingappbackend.service.ReviewService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review,Integer> {

        List<Review> findByMovieId(int id);

}
