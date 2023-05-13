package film.movieblog.service;

import film.movieblog.data.MovieRepository;
import film.movieblog.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    public void addMovie(Movie movie){

    }
}
