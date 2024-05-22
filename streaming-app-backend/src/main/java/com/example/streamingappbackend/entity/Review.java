package com.example.streamingappbackend.entity;

import com.example.streamingappbackend.type.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Rating rating;
    private String message;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Guest guest;

    public Review(Rating rating, String message) {
        this.rating = rating;
        this.message = message;
    }


}
