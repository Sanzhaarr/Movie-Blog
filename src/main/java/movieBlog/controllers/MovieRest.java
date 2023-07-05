package movieBlog.controllers;

import lombok.Data;
import movieBlog.Movie;
import movieBlog.data.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
public class MovieRest {

    private MovieRepository movieRepository;
    private Movie movie;

    @Autowired
    public MovieRest(MovieRepository movieRepository, Movie movie) {
        this.movieRepository = movieRepository;
        this.movie = movie;
    }

    @GetMapping("/films")
    public List<Movie> showAllMovies(){
        return movieRepository.findAll();
    }

    @PostMapping("/films")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);

    }
    
}

