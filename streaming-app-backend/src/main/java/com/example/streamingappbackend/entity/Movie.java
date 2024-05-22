package com.example.streamingappbackend.entity;

import com.example.streamingappbackend.type.Category;
import com.example.streamingappbackend.type.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonProperty("release_year")
    private Integer releaseYear;
    private String overview;
    private String director;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String imageUrl;
    private String videoUrl;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews = new ArrayList<>() ;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    private Set<Guest> guests = new HashSet<>();


    public void addGuest(Guest  guest){
        guest.getMovies().add(this);
        guests.add(guest);
    }


    public void addReview(Review review){
        review.setMovie(this);
        reviews.add(review);
    }


    public Movie(String name, Integer releaseYear, String director, Type type,Category category,String imageUrl,String overview) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
        this.type = type;
        this.category = category;
        this.imageUrl=imageUrl;
        this.overview=overview;

    }
}
