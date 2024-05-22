package com.example.streamingappbackend.dao;

import com.example.streamingappbackend.entity.Guest;
import com.example.streamingappbackend.entity.Movie;
import com.example.streamingappbackend.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MovieRepo extends JpaRepository<Movie,Integer> {

        boolean existsByGuests(Set<Guest> guests);

        List<Movie> findMovieByType(Type type);

}
