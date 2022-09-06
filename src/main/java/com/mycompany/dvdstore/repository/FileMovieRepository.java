package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;


import java.io.FileWriter;
import java.io.IOException;

public class FileMovieRepository implements MovieRepositoryInterface {

    private final String databaseFolder = "C:\\temp\\";
    private final String databaseFile = "movies.txt";


    public void add(Movie movie){
        writeIntoFile(movie);
        System.out.println("Le film " + movie.getTitle() + " (genre: " + movie.getGenre() + ") a bien été ajouté à la liste.");
    }


    public void writeIntoFile(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter(databaseFolder + databaseFile,true);
            writer.write(movie.getTitle()+";"+movie.getGenre()+"\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
