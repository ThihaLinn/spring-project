package com.example.streamingappbackend.service;

import com.example.streamingappbackend.dao.GuestRepo;
import com.example.streamingappbackend.dao.MovieRepo;
import com.example.streamingappbackend.dao.ReviewRepo;
import com.example.streamingappbackend.dto.ReviewDto;
import com.example.streamingappbackend.entity.Movie;
import com.example.streamingappbackend.exception.ResourceNotFoundException;
import com.example.streamingappbackend.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.streamingappbackend.mapper.ReviewMapper.*;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepo reviewRepo;
    private final MovieRepo movieRepo;
    private final GuestRepo guestRepo;

    //SkillFull Thinking
    public String addReview(ReviewDto reviewDto,Integer id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        var guest = guestRepo.findGuestByName(authentication.getName());
        var movie = movieRepo.findById(id).orElseThrow();
        var review = toEntity(reviewDto);
        var check =movie.getGuests().stream().filter(g -> g.getId().equals(guest.getId())).toList();
        if(!check.isEmpty()){
            return "Already give review";
        }else {
            guest.addReview(review);
            movie.addGuest(guest);
            movie.addReview(review);
            movieRepo.save(movie);

            return "Successfully add review";

        }


    }

    public List<ReviewDto> reviewsForSelectedMovie(Integer id){
            return reviewRepo.findByMovieId(id)
                    .stream()
                    .map(ReviewMapper::toDto)
                    .collect(Collectors.toList());
    }

    public String deleteReview(Integer id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        var review = reviewRepo.findById(id).get();
            if(reviewRepo.existsById(id)) {
                if(review.getGuest().getName().equals(authentication.getName())){
                    reviewRepo.deleteById(id);
                    return "Successfully Deleted";
                }
            }else {
                throw new  ResourceNotFoundException("Id don't found");
            }
       return "You don't have permission to delete this.";
    }



}
