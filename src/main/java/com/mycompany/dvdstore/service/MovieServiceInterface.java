package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;

import java.util.List;

public interface MovieServiceInterface {

    Movie registerMovie(Movie movie);
    void setMovieRepository(MovieRepositoryInterface movieRepository);
    Iterable<Movie> getMovieList();
    Movie getMovieById(Long id);
}