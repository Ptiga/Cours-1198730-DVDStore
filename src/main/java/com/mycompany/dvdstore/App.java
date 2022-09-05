package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.controller.MovieControllerInterface;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.service.DefaultMovieService;
import com.mycompany.dvdstore.service.MovieServiceInterface;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        Scanner lectureClavier = new Scanner(System.in);


        System.out.println("Quel est la classe contrôleur ?");
        System.out.println("'1 - Default'");
        String controllerClass = ControllerChoice(lectureClavier.nextInt());

        System.out.println("Quel est la classe service ?");
        System.out.println("'1 - Default'");
        String serviceClass = ServiceChoice(lectureClavier.nextInt());

        System.out.println("Quel est la classe repository ?");
        System.out.println("'1 - Default (en mémoire)', '2 - Dans fichier'");
        String repositoryClass = RepositoryChoice(lectureClavier.nextInt());





        MovieControllerInterface movieController=null;
        MovieServiceInterface movieService=null;
        MovieRepositoryInterface movieRepository=null;



        try{
            movieController = (MovieControllerInterface) Class.forName(controllerClass).getDeclaredConstructor().newInstance();
            movieService = (MovieServiceInterface) Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            movieRepository = (MovieRepositoryInterface) Class.forName(repositoryClass).getDeclaredConstructor().newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }

        movieController.setMovieService(movieService);
        movieService.setMovieRepository(movieRepository);

        movieController.addUsingConsole();
    }



    public static String ControllerChoice(Integer choix){
       switch (choix){
            case 1:
                return "com.mycompany.dvdstore.controller.MovieController";
           default:
               return "com.mycompany.dvdstore.controller.MovieController";
       }
    }

    public static String ServiceChoice(Integer choix){
        switch (choix){
            case 1:
                return "com.mycompany.dvdstore.service.DefaultMovieService";
            default:
                return "com.mycompany.dvdstore.service.DefaultMovieService";
        }
    }

    public static String RepositoryChoice(Integer choix){
        switch (choix){
            case 1:
                return "com.mycompany.dvdstore.repository.MemoryMovieRepository";
            case 2:
                return "com.mycompany.dvdstore.repository.FileMovieRepository";
            default:
                return "com.mycompany.dvdstore.repository.MemoryMovieRepository";
        }
    }
}
