package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;

public interface MovieServiceInterface {

    void registerMovie(Movie movie);
    void setMovieRepository(MovieRepositoryInterface movieRepository);
}
