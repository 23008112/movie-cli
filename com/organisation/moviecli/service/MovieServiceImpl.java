package com.organisation.moviecli.service;


import com.organisation.moviecli.model.Movie;
import com.organisation.moviecli.repo.MovieRepository;
import com.organisation.moviecli.util.ApiData;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    
    private final MovieRepository repository;
    private final ApiData apiData;

    public MovieServiceImpl(MovieRepository repository, ApiData apiClient) {
        this.repository = repository;
        this.apiData = apiClient;
    }

    @Override
    public List<Movie> trendingMovie()
    {


            List<Movie> trending = apiData.fetchTrendingMovies();
            repository.saveAll(trending);
            return trending;


    }

    @Override
    public List<Movie> searchMovies(String query)
    {

            List<Movie> results = apiData.searchMovies(query);
            repository.saveAll(results);
            return results;

    }

    @Override
    public List<Movie> movieGenre(String genre)
    {
        return repository.findByGenre(genre);
    }

    @Override
    public List<Movie> getAllMovie()
    {
        return repository.findAll();
    }
}
