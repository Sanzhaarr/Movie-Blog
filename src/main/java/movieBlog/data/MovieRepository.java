package movieBlog.data;

import movieBlog.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByName(String name);
    Map<String, String> updateMovie(Movie movie);
    List<Movie> deleteByName(String name);

}


