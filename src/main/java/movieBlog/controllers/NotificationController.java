package movieBlog.controllers;

import movieBlog.Movie;
import movieBlog.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private MovieService movieService;

    public NotificationController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie-created")
    public ResponseEntity<String> notifyMovieCreated(@RequestBody Movie movie) {
        String message = "Movie created: " + movie.getName();
        // Implement code to send notification message to users
        return ResponseEntity.ok(message);
    }

    @PostMapping("/movie-updated")
    public ResponseEntity<String> notifyMovieUpdated(@RequestBody Movie movie) {
        String message = "Movie updated: " + movie.getName();
        // Implement code to send notification message to users
        return ResponseEntity.ok(message);
    }

//    @PostMapping("/movie-deleted")
//    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {
//        Movie movie = movieService.getMovieById(id);
//
//        if (movie == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        movieService.deleteMovie(id);
//        String message = "Movie deleted: " + movie.getName();
//        return ResponseEntity.ok(message);
//    }
}
