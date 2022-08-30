package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository implements MovieRepositoryInterface{

    private static List<Movie> listeFilms = new ArrayList<>();

    public void add(Movie movie){
        listeFilms.add(movie);
        System.out.println("Le film " + movie.getTitle() + " (genre: " + movie.getGenre() + ") a bien été ajouté à la liste.");
    }
}
