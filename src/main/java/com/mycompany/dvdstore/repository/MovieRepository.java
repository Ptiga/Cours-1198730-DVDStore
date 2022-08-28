package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private static List<Movie> listeFilms = new ArrayList<>();

    public void addMovie(Movie movie){
        listeFilms.add(movie);
        System.out.println("Le film " + movie.getTitle() + " (genre: " + movie.getGenre() + ") a bien été ajouté à la liste.");
    }
}
