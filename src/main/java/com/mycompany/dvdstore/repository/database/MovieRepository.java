package com.mycompany.dvdstore.repository.database;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.hibernate.tool.schema.internal.exec.JdbcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie add(Movie movie) {
        String requeteSql = "INSERT INTO movie (title, genre, description) values(?, ?, ?)";
        KeyHolder kh = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(requeteSql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setString(3, movie.getDescription());
            return ps;
        }, kh);

        //movie.setId(Long.parseLong(kh.getKey().toString()));
        movie.setId(kh.getKey().longValue());

        System.out.println("Rajouté à la liste : "+ '\n' + movie);

        return movie;
    }

    @Override
    public List<Movie> list() {
        String requeteSql = "SELECT id, title, genre FROM movie";
        return jdbcTemplate.query(requeteSql,
                (resultSet, numLigne) -> new Movie(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre")
                ));
    }

    @Override
    public Movie getById(long id) {
        String requeteSql = "SELECT * FROM movie WHERE id = ?";
        return jdbcTemplate.queryForObject(requeteSql,
                new Object[]{id},
                (resultSet, numLigne) -> new Movie(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getString("description")
                ));
    }
}
