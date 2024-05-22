package com.example.streamingappbackend.dto;

import com.example.streamingappbackend.type.Rating;

public record ReviewDto (
        Integer id,
        Rating rating,
        String message
){




}
