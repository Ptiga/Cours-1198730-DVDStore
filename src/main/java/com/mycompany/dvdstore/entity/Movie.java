package com.mycompany.dvdstore.entity;


import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String description;
    //@JoinColumn(name = "id_actor", nullable = false)
    //private Actor mainActor;


    public Movie() {
    }


    public Movie(Long id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }


    public Movie(Long id, String title, String genre, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film: " + '\n' +
                "- ID : " + id + '\n' +
                "- Titre : " + title + '\n' +
                "- Genre : " + genre + '\n' +
                "- Description : " + description + '\n';
    }
}