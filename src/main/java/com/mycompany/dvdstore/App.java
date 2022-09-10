package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.repository.file.FileMovieRepository;
import com.mycompany.dvdstore.repository.memory.MemoryMovieRepository;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration
@ComponentScan(basePackages = {"com.mycompany.dvdstore.controller", "com.mycompany.dvdstore.service"/*, "com.mycompany.dvdstore.repository.file"*/})
@PropertySource("classpath:application.properties")
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        MovieControllerInterface movieController = applicationContext.getBean(MovieControllerInterface.class);

        movieController.addUsingConsole();
    }

    @Bean
    public MovieRepositoryInterface configureMovieRepository(){
        return new FileMovieRepository();
    }

}
