package com.organisation.moviecli.util;

import com.organisation.moviecli.model.Movie;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ApiData {
    
    // Mock database representing external API data
    private final List<Movie> externalDatabase = Arrays.asList(
            new Movie("1","youth","comedy",true),
            new Movie("2","With Love","romance",true),
            new Movie("3","Spider man","fiction",true),
            new Movie("4","kanchana","horror",false),
            new Movie("5","Muthu","comedy",false)
    );

    public List<Movie> fetchTrendingMovies() {

        return externalDatabase.stream().filter(Movie::isTrending).collect(Collectors.toList());
    }

    public List<Movie> searchMovies(String query) {

        return externalDatabase.stream().filter(m -> m.getTitle().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList());
    }


    }

