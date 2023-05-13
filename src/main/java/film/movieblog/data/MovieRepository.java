package film.movieblog.data;

import film.movieblog.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByName(String name);
    List<Movie> findByGenre(String genre);
    List<Movie> findByYearOrderByYearAsc(Integer year);

}


