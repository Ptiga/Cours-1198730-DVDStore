package com.mycompany.dvdstore.repository.memory;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private static List<Movie> listeFilms = new ArrayList<>();

    public void add(Movie movie){
        listeFilms.add(movie);
        System.out.println("Le film " + movie.getTitle() + " (genre: " + movie.getGenre() + ") a bien été ajouté à la liste.");
    }

    @Override
    public List<Movie> list() {
        Movie film1 = new Movie("Sleepy Hollow", "Fantastique");
        Movie film2 = new Movie("Pacific Rim", "Science-Fiction");
        List<Movie>movies=List.of(film1, film2);
        return movies;
    }
}
