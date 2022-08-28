package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;

public class MovieController {

    public void addUsingConsole(){
        Scanner lectureClavier = new Scanner(System.in);

        System.out.println( "Quel est le titre du film ?" );
        String titreFilm = lectureClavier.nextLine();

        System.out.println( "Quel est le genre du film ?" );
        String genreFilm = lectureClavier.nextLine();

        Movie movie = new Movie(titreFilm, genreFilm);

        MovieService movieService = new MovieService();
        movieService.registerService(movie);

    }
}
