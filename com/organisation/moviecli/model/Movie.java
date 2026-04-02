package com.organisation.moviecli.model;

import java.util.Objects;

public class Movie {
    private final String id;
    private final String title;
    private final String genre;
    private final boolean isTrending;

    public Movie(String id, String title, String genre, boolean isTrending)
    {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.isTrending = isTrending;
    }

    public String getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public String getGenre()
    {
        return genre;
    }
    public boolean isTrending()
    {
        return isTrending;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return String.format("[%s] %s (Genre: %s) %s", 
                id, title, genre, isTrending ? "[TRENDING]" : "");
    }
}
