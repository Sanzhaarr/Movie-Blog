package movieBlog.data;

import movieBlog.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public class MovieData {

    private MovieRepository movieRepository;

    @Autowired
    public MovieData(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findByName(String name){
        return movieRepository.findByName(name);

    }
}
