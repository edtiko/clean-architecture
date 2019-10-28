package app.demo.jpa.movies;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface MovieDataRepository extends CrudRepository<MovieData, String>, QueryByExampleExecutor<MovieData> {
    @Query(value = "SELECT * FROM Movies m WHERE m.Category = :category", nativeQuery = true)
    List<MovieData> findMoviesByCategory(@Param("category") String category);
}
