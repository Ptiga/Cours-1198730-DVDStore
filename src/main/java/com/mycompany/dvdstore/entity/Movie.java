package com.mycompany.dvdstore.entity;

public class Movie {

    private long id;
    private String title;
    private String genre;
    private String description;


    public Movie() {
    }


    public Movie(long id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }


    public Movie(long id, String title, String genre, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
