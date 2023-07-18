package movieBlog.service;

import movieBlog.Movie;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Map;

public interface MovieService {

    public Movie createMovie(Movie movie);
    public abstract Map<String, String> updateMovie();
    public ResponseEntity<String> deleteMovie(Movie id);
    public Collection<Movie> getMovies();
}
