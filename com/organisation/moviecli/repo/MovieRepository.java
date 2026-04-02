package com.organisation.moviecli.repo;

import com.organisation.moviecli.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieRepository
{
    void save(Movie movie);
    void saveAll(List<Movie> movies);
    List<Movie> findAll();
    List<Movie> findByGenre(String genre);
}
