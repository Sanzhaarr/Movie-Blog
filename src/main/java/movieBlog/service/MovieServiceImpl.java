package movieBlog.service;

import movieBlog.MovieNotFoundException;
import movieBlog.data.MovieRepository;
import movieBlog.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepo;
    private Movie movie;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
        this.movie = movie;
    }



    @Override
    public Movie createMovie(Movie movie) {
//        return movieRepo.save(movie);
//    }

//TODO:  USE TRY/CATCH, IF MOVIE ALREADY EXISTS

        try{
            if (movieRepo.findByName(movie.getName()).isEmpty())
                return movieRepo.save(movie);

        }catch (MovieNotFoundException e){
            e.getMessage();
        }
        return movie;
    }

    @Override
    public Map<String, String> updateMovie() {
        Optional<Movie> optionalMovie = movieRepo.findById(movie.getId());
        Map<String, String> updateMovie = new HashMap<>();

        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setName(movie.getName());
            // Update other properties as needed
            // ...

            // Save the updated movie
            movieRepo.save(existingMovie);

            updateMovie.put("status", "success");
            updateMovie.put("message", "Movie updated successfully");
        } else {
            updateMovie.put("status", "error");
            updateMovie.put("message", "The movie does not exist");
        }

        return updateMovie;
    }


//    @Override
//    public Map<String, String> updateMovie(Movie id) {
//        Movie newMovie = movieRepo.findById(movie.getId()).get();
//        Map<String, String> updateMovie = new HashMap<>();
//        updateMovie.put("name", " " + movie.getName());
//        if (!movie.getName().isEmpty()){
//            updateMovie.put(String.valueOf(id), "The movie does not exist");
//
//        }
//
//        return updateMovie;
//    }


    @Override
    public ResponseEntity<String> deleteMovie(Movie id) {
        try{
            movieRepo.delete(id);
            return ResponseEntity.ok("The movie has been deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete movie");
        }



    }

    @Override
    public Collection<Movie> getMovies() {
        Collection<Movie> movies = new HashSet<>();
        Iterator<Movie> movieIterator = movies.iterator();
        movies.forEach(m -> {
            movieIterator.hasNext();
        });
        return movies;
    }
}
