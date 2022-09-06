package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.controller.MovieControllerInterface;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.service.DefaultMovieService;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MovieControllerInterface movieController = applicationContext.getBean(MovieControllerInterface.class);

        movieController.addUsingConsole();
    }
}
