package film.movieblog.controllers;

import film.movieblog.data.MovieRepository;
import film.movieblog.Movie;
import film.movieblog.Profile;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Data
@Controller
public class MovieController {

    public final Movie movie;
    public final Profile profile;
    public final MovieRepository movieRepository;

    public MovieController(Movie movie, Profile profile, MovieRepository movieRepository) {
        this.movie = movie;
        this.profile = profile;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/films")
    public String listFilms(Model model,@ModelAttribute Movie movie) {
        model.addAttribute("name", "Back to the Future");
        model.addAttribute("genre", "Fantasy, science-fiction");
        model.addAttribute("release ", "1985");

        return "movies.html";
    }

    @PostMapping("/movies")
    public String addMovie(@ModelAttribute Movie movie){
        movieRepository.save(movie);
        return "redirect:/films";
    }




}
