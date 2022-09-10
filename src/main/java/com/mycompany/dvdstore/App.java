package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.repository.file.FileMovieRepository;
import com.mycompany.dvdstore.repository.memory.MemoryMovieRepository;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext = SpringApplication.run(App.class);
        MovieControllerInterface movieController = applicationContext.getBean(MovieControllerInterface.class);

        movieController.addUsingConsole();
    }



}
