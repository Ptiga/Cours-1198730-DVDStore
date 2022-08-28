package com.mycompany.dvdstore;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
