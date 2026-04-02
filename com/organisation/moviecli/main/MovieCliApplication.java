package com.organisation.moviecli.main;


import com.organisation.moviecli.model.Movie;
import com.organisation.moviecli.repo.MovieRepoImp;
import com.organisation.moviecli.repo.MovieRepository;
import com.organisation.moviecli.service.MovieService;
import com.organisation.moviecli.service.MovieServiceImpl;
import com.organisation.moviecli.util.ApiData;

import java.util.List;
import java.util.Scanner;

public class MovieCliApplication {

    private final MovieService movieService;

    // Dependency Injection via constructor
    public MovieCliApplication(MovieService movieService)
    {
        this.movieService = movieService;
    }

    public void start()
    {
        System.out.println("Movie management system");

        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCommands: [search <title>] | [genre <name>] | [trending] | [local] | [exit]");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : "";


                switch (command) {
                    case "search":
                        if (argument.isEmpty()) {
                            System.out.println("Please provide a search query. (e.g., search kanchana)");
                        } else {

                            printMovies(movieService.searchMovies(argument));
                        }
                        break;
                    case "genre":
                        if (argument.isEmpty()) {
                            System.out.println("Please provide a genre. (e.g., genre Action)");
                        } else {

                            printMovies(movieService.movieGenre(argument));
                        }
                        break;
                    case "trending":

                        printMovies(movieService.trendingMovie());
                        break;
                    case "local":

                        printMovies(movieService.getAllMovie());
                        break;
                    case "exit":
                        System.out.println("Exiting application. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Unknown command. Please try again.");
                }

        }
        scanner.close();
    }

    private void printMovies(List<Movie> movies) {
        if (movies == null || movies.isEmpty()) {
            System.out.println("No movies to display.");
            return;
        }
        movies.forEach(movie -> System.out.println("  " + movie));
        System.out.println("  (" + movies.size() + " result/s found)");
    }

    public static void main(String[] args) {
        // Manual Application Context / Dependency Wiring
        ApiData apiClient = new ApiData();
        MovieRepository repository = new MovieRepoImp();
        MovieService service = new MovieServiceImpl(repository, apiClient);
        
        MovieCliApplication app = new MovieCliApplication(service);
        app.start();
    }
}
