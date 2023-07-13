package movieBlog.controllers;

import movieBlog.data.MovieRepository;
import movieBlog.Movie;
import movieBlog.Profile;
import movieBlog.service.MovieService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Data
@Controller
public class MovieController {

    public final Movie movie;
    public final Profile profile;
    public final MovieRepository movieRepository;
    public final MovieService movieService;

    @Autowired
    public MovieController(Movie movie, Profile profile, MovieRepository movieRepository, MovieService movieService) {
        this.movie = movie;
        this.profile = profile;
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> showMovies(){
        return movieService.getAllMovies();
    }

//    @GetMapping("/movies/new")
//    public String AddMovieForm(Model model) {
//        model.addAttribute("movie", new Movie());
//        return "add_movies.html";
//    }
//
//
//    @PostMapping("/movies/new/add")
//    public String addMovieSubmit(@ModelAttribute Movie movie) {
//        movieRepository.save(movie);
//        return "redirect:/movies";
//    }
    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable String movieId){
        return movieService.getMovieById((long) Integer.parseInt(movieId));
    }

    @PostMapping("/movies/add")
    public Movie addMovie(Movie movie){
        return movieService.createMovie(movie);
    }








}
