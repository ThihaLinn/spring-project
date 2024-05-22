package com.example.streamingappbackend.api;

import com.example.streamingappbackend.dto.MovieDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class Api {

    public final RestClient restClient;

    private final String API_KEY = "d59054e8817bb1832d3f5a95362322bf";
    private final String BASE_URL = "https://api.themoviedb.org/3";
    public Api (){
        restClient = RestClient.builder()
                .baseUrl(BASE_URL)
                .build();
        System.out.println(restClient);

    }

    public void getActionMovie (String number){
        var movies = restClient
                .get()
                .uri("/discover/movie?api_key="+API_KEY+"&language=en-US&with_genres=")
                .retrieve()
                .toBodilessEntity();

    }




}
