package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.ActorRepositoryInterface;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DefaultMovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepositoryInterface movieRepository;

    @Autowired
    private ActorRepositoryInterface actorRepository;

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }


//private GoLiveMovieRepository movieRepository = new GoLiveMovieRepository();

    @Transactional
    public Movie registerMovie(Movie movie){
        actorRepository.save(movie.getMainActor());
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Iterable<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        /*
        return getMovieList().stream().
                filter(m -> m.getId()==id).
                findFirst().get();
         */
        //return movieRepository.findById(id).orElseThrow();
        /*
        //Version qui fait des requêtes pour obtenir les éléments suplémentaires
        Optional<Movie> optionalMovie=movieRepository.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        Movie movie=optionalMovie.get();
        //Initialize proxys
        movie.getMainActor().getFirstName();
        movie.getReviews().forEach(review -> {
            review.getMark();
            review.setMovie(null);
        });
        return movie;
         */
        Optional<Movie> optionalMovie=movieRepository.findById(id);
        if (optionalMovie.isEmpty()){
            throw new NoSuchElementException();
        }
        Movie movie=optionalMovie.get();

        movie.getReviews().forEach(review ->
                review.setMovie(null)
        );

        return movie;

    }
}