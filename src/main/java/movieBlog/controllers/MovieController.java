package movieBlog.controllers;

import movieBlog.data.MovieRepository;
import movieBlog.Movie;
import movieBlog.Profile;
import movieBlog.service.MovieService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

//    @GetMapping("/movies/new")
//    public String AddMovieForm(Model model) {
//        model.addAttribute("movie", new Movie());
//        return "add_movies.html";
//    }
//
//
//    @PostMapping("/movies/new")
//    public String addMovieSubmit(@ModelAttribute Movie movie) {
////
//        movieRepository.save(movie);
//        return "redirect:/movies";
//    }


//    @PostMapping("/movies/new")
//    public String addMovieSubmit(HttpServletRequest request) {
//        try {
//            String name = request.getParameter("name");
//            String genre = request.getParameter("genre");
//            int year = Integer.parseInt(request.getParameter("year"));
//
//            Movie movie = new Movie();
//            movie.setName(name);
//            movie.setGenre(genre);
//            movie.setYear(year);
//
//            movieRepository.save(movie);
//
//            return "redirect:/movies.html";
//        } catch (Exception e) {
//            return "error-page.html";
//        }
//    }


}
