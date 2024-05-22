package com.example.streamingappbackend.service;

import com.example.streamingappbackend.app.Favourite;
import com.example.streamingappbackend.dao.GuestRepo;
import com.example.streamingappbackend.dao.MovieRepo;
import com.example.streamingappbackend.dto.MovieDto;
import com.example.streamingappbackend.entity.Movie;
import com.example.streamingappbackend.mapper.MovieMapper;
import com.example.streamingappbackend.type.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.streamingappbackend.mapper.MovieMapper.*;

@Service
@RequiredArgsConstructor
public class MovieService {

    public final MovieRepo movieRepo;

    public final GuestRepo guestRepo;


    public List<MovieDto> getAllMovies() {
        return movieRepo.findAll()
                .stream()
                .map(MovieMapper::toDto)
                .collect(Collectors.toList());
    }

    public MovieDto getMovie(Integer id) {
        var movie = movieRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));
        return toDto(movie);

    }

    public String uploadMovie(MovieDto movieDto) {
        var movie = toEntity(movieDto);
        movieRepo.save(movie);
        return "Upload Successfully";
    }

    public String updateMovie(MovieDto movieDto, Integer id) {
        var movie = toEntity(movieDto);
        movie.setId(id);
        movieRepo.save(movie);
        return "Update Successfully";
    }

    public String deleteMovie(Integer id) {
        if (movieRepo.existsById(id)) {
            movieRepo.deleteById(id);
            return "Delete successfully";
        }
        throw new RuntimeException("Id not found");
    }

    public List<MovieDto> findMovieByType(Type type) {
        var movie = movieRepo.findMovieByType(type)
                .stream()
                .map(MovieMapper::toDto)
                .collect(Collectors.toList());
        ;
        return movie;
    }

    public void addFavMovie(int id, String gmail) {
        if (guestRepo.existsByGmail(gmail) && movieRepo.existsById(id)) {
            var guest = guestRepo.findGuestByGmail(gmail).get();
            var movie = movieRepo.findById(id).get();

            guest.addMovie(movie);
            guestRepo.save(guest);

        }

    }


    public void removeMovie(int id, String gmail) {
        if (guestRepo.existsByGmail(gmail) && movieRepo.existsById(id)) {
            var guest = guestRepo.findGuestByGmail(gmail).get();
            var movie = movieRepo.findById(id).get();

            guest.removeMovie(movie);
            guestRepo.save(guest);

        }
    }

    public boolean check(int id,String gmail) {
        var guest  = guestRepo.findGuestByGmail(gmail).get();
        var movie = movieRepo.findById(id).get();
        return guest.getMovies().contains(movie);
    }

    public Set<MovieDto> FavMovies(String gmail) {
        if (guestRepo.existsByGmail(gmail)) {
            var guest = guestRepo.findGuestByGmail(gmail);
            return guest.get().getMovies()
                    .stream()
                    .map(MovieMapper::toDto)
                    .collect(Collectors.toSet());
        }
        return null;

    }


}
