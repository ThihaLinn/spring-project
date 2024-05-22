package com.example.streamingappbackend.controller;

import com.example.streamingappbackend.dto.ReviewDto;
import com.example.streamingappbackend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/add-review/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<String> addReview(@RequestBody ReviewDto reviewDto,@PathVariable Integer id){

       var result = reviewService.addReview(reviewDto,id);
       return ResponseEntity.ok(result);
    }

    @GetMapping("/movie/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<List<ReviewDto>> reviewsForSelectedMovie(@PathVariable Integer id){
        var result = reviewService.reviewsForSelectedMovie(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete-review/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<String> deleteReview(@PathVariable Integer id){
        var result = reviewService.deleteReview(id);
        return ResponseEntity.ok(result);
    }

}
