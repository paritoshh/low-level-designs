package com.parit.bms.services;

import com.parit.bms.dtos.CreateMovieDto;
import com.parit.bms.exceptions.MovieNotFoundException;
import com.parit.bms.models.Movie;
import com.parit.bms.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;
    public Movie createMovie(Movie movie) {

        //check for existing movie.
        if(movieRepository.findByTitle(movie.getTitle()).isPresent()){
            throw new IllegalArgumentException("Movie already exists, name :"+movie.getTitle());
        }
        return movieRepository.save(movie);

    }

    public Movie getMovie(Long id) {

       return movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Movie not found id : "+id));
    }
}
