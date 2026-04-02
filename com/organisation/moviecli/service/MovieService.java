package com.organisation.moviecli.service;

import com.organisation.moviecli.model.Movie;
import java.util.List;

public interface MovieService {
    List<Movie> trendingMovie();
    List<Movie> searchMovies(String query);
    List<Movie> movieGenre(String genre);
    List<Movie> getAllMovie();
}
