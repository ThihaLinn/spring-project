package com.example.streamingappbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String gmail;
    @Column(nullable = false)
    private String password;

    private Boolean status;

    @OneToMany(mappedBy = "guest",cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();


    public void addMovie (Movie movie){
        movie.getGuests().add(this);
        movies.add(movie);
    }

    public void removeMovie(Movie movie){
        movies.remove(movie);
    }



    public void addReview(Review review){
        review.setGuest(this);
        reviews.add(review);
    }


    public Guest(String name, String gmail, String password) {
        this.name = name;
        this.gmail = gmail;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
