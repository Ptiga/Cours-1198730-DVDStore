package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieControllerInterface movieController = applicationContext.getBean(MovieControllerInterface.class);

        movieController.addUsingConsole();
    }
}
