package com.example.streamingappbackend.dto;

import com.example.streamingappbackend.type.Category;
import com.example.streamingappbackend.type.Type;

public record MovieDto (
        Integer id,
        String name,
        Integer releaseYear,
        String director,
        Type type,
        Category category,
        String imgUrl,
        String overview

){
}
