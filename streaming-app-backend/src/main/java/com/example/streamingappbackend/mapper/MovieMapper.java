package com.example.streamingappbackend.mapper;

import com.example.streamingappbackend.dto.MovieDto;
import com.example.streamingappbackend.entity.Movie;

public class MovieMapper {

    public static MovieDto toDto(Movie movie){
        return new MovieDto(
                movie.getId(),
                movie.getName(),
                movie.getReleaseYear(),
                movie.getDirector(),
                movie.getType(),
                movie.getCategory(),
                movie.getImageUrl(),
                movie.getOverview()
        );
    }

    public static Movie toEntity(MovieDto movieDto){
        return new Movie(
                movieDto.name(),
                movieDto.releaseYear(),
                movieDto.director(),
                movieDto.type(),
                movieDto.category(),
                movieDto.imgUrl(),
                movieDto.overview()
        );
    }

}
