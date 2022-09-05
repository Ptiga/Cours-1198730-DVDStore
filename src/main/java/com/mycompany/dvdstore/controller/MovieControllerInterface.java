package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.service.MovieServiceInterface;

public interface MovieControllerInterface {

    void addUsingConsole();
    void setMovieService(MovieServiceInterface movieService);
}
