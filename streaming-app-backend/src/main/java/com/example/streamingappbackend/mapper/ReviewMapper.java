package com.example.streamingappbackend.mapper;

import com.example.streamingappbackend.dto.ReviewDto;
import com.example.streamingappbackend.entity.Review;

public class ReviewMapper {

    public static ReviewDto toDto(Review review){
        return new ReviewDto(
                review.getId(),
                review.getRating(),
                review.getMessage()
        );
    }

    public static Review toEntity(ReviewDto reviewDto){
        return new Review(
                reviewDto.rating(),
                reviewDto.message());
    }

}
