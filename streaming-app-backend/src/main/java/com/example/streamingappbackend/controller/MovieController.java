package com.example.streamingappbackend.controller;

import com.example.streamingappbackend.dto.MovieDto;
import com.example.streamingappbackend.service.MovieService;
import com.example.streamingappbackend.type.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<MovieDto>> movieList(){
        var movies = movieService.getAllMovies();
        return  ResponseEntity.ok(movies);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<MovieDto>> horrorMovies(@PathVariable Type type){
        var movies = movieService.findMovieByType(type);
        return  ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Integer id){
        var movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/upload")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> uploadMovie(@RequestBody MovieDto movieDto){
        var result = movieService.uploadMovie(movieDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> updateMovie(@RequestBody MovieDto movieDto,@PathVariable Integer id){
        var result = movieService.updateMovie(movieDto,id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id){
        var result = movieService.deleteMovie(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/add-movie/{gmail}/{id}")
    public ResponseEntity<String> addFavourite(@PathVariable Integer id,@PathVariable String gmail){
         movieService.addFavMovie(id,gmail);
         return ResponseEntity.ok("Successfully add movie") ;
     }

     @GetMapping("/remove-movie/{gmail}/{id}")
     public ResponseEntity<String> removeFavourite(@PathVariable Integer id,@PathVariable String gmail){
        movieService.removeMovie(id,gmail);
         return ResponseEntity.ok("Successfully remove movie") ;
     }

    @GetMapping("/favourite/{gmail}")
    public ResponseEntity<Set<Integer>> favourite(@PathVariable String gmail ){
        var result =movieService.
        return ResponseEntity.ok(result);
    }

    @GetMapping("/check/{gmail}/{id}")
    public ResponseEntity<Boolean> check(@PathVariable Integer id,@PathVariable String gmail){
        var result =movieService.check(id,gmail);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/favMovies/{gmail}")
    public ResponseEntity<Set<MovieDto>> favMovies(@PathVariable String gmail){
        var result = movieService.FavMovies(gmail);
        return ResponseEntity.ok(result);
    }
}
