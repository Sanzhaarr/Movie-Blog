package movieBlog.controllers;

import lombok.Data;
import movieBlog.Movie;
import movieBlog.data.MovieRepository;
import movieBlog.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Data
@RestController
@CrossOrigin("http://localhost:3000")
public class MovieController {

    private MovieRepository movieRepository;
    private Movie movie;
    private MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieRepository movieRepository, MovieServiceImpl movieService) {
        this.movieRepository = movieRepository;
        this.movie = movie;
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public Collection<Movie> showAllMovies(){
        return movieRepository.findAll();
    }

    @PostMapping("/movies/new")
    public String addMovie(@RequestBody Movie movie) {
        movieService.createMovie(movie);
        return "Movie added";
    }

    @PutMapping("/movies/update/{id}")
    public Map<String, String> updateMovie(){
        return movieService.updateMovie();
    }

    @DeleteMapping("/movies/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Movie id){
        //TODO: 1) IF USER AUTHENTICATED, 2)IF MOVIE EXISTS, 3) UPDATE NEW VERSION
        return movieService.deleteMovie(id);

    }
    
}

