package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.GoLiveMovieRepository;
import com.mycompany.dvdstore.repository.MovieRepository;
import com.mycompany.dvdstore.service.MovieService;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        Scanner lectureClavier = new Scanner(System.in);

/*
        System.out.println("Dans quelle configuration êtes-vous ?");
        System.out.println("1 > Configuration d'origine");
        System.out.println("2 > Configuration GoLiveMovie");

        int configuration = lectureClavier.nextInt();
*/
        MovieController movieController = new MovieController();
        GoLiveMovieRepository movieRepository = new GoLiveMovieRepository();
        MovieService movieService = new MovieService();
        movieController.setMovieService(movieService);
        //GoLiveMovieRepository movieRepository = new GoLiveMovieRepository();
        movieService.setMovieRepository(movieRepository);
        movieController.addUsingConsole();
    }
}
