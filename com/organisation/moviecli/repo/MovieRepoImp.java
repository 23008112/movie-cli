package com.organisation.moviecli.repo;

import com.organisation.moviecli.model.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MovieRepoImp implements MovieRepository {

    private final Set<Movie> database = ConcurrentHashMap.newKeySet();

    @Override
    public void save(Movie movie)
    {
        Optional.ofNullable(movie).ifPresent(database::add);
    }

    @Override
    public void saveAll(List<Movie> movies)
    {
        Optional.ofNullable(movies).ifPresent(database::addAll);
    }

    @Override
    public List<Movie> findAll()
    {
        return new ArrayList<>(database);
    }

    @Override
    public List<Movie> findByGenre(String genre)
    {
        return database.stream().filter(m -> m.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
    }
}
