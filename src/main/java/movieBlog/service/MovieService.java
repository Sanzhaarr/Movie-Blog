package movieBlog.service;

import movieBlog.MovieNotFoundException;
import movieBlog.data.MovieRepository;
import movieBlog.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepo;
    private Movie movie;


    public MovieService(MovieRepository movieRepo, Movie movie) {
        this.movieRepo = movieRepo;
        this.movie = movie;
    }

    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }

    public Movie getMovieById(Long id){
        return movieRepo.findById(id).orElseThrow(() -> new MovieNotFoundException(movie.getName())); //id
    }

    public Movie createMovie(Movie movie){
        return movieRepo.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails){
        Movie movie = getMovieById(id);

        movie.setYear(movieDetails.getYear());
        movie.setGenre(movieDetails.getGenre());
        movie.setName(movieDetails.getName());

        return movieRepo.save(movie);
    }

//TODO ADD CUSTOM METHOD DELETING BY ENTITY
// public void deleteMovie(String name){
//        return movieRepo.deleteByName(name);
//    }

    public void deleteMovie(String name){
        movieRepo.deleteByName(name);
    }
}
