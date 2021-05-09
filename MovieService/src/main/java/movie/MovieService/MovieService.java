package movie.MovieService;

import movie.MovieService.model.MovieModel;
import movie.MovieService.model.category.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {

    private List<MovieModel> movies;

    public MovieService() {

        this.movies = List.of(new MovieModel(1L, "The Hunt", Category.Horror),
                new MovieModel(2L, "Dark Waters", Category.History),
                new MovieModel(3L, "Fantasy Island", Category.Fantasy)
        );

    }


    public List<MovieModel> getAllMovies() {

        return this.movies;
    }

    public MovieModel getMovieById(Long id) {

        for (MovieModel movie : this.movies) {
            if (movie.getId().equals(id)) {
                return movie;
            }else throw new ResponseStatusException( HttpStatus.NOT_FOUND);
        }
        return null;
    }
    public MovieModel updateMovie(MovieModel movie) {
        Long movieId = movie.getId();
        MovieModel movieToUpdate = this.getMovieById(movieId);
        if(movieToUpdate == null) {
            return null;
        }

        movieToUpdate.setName(movie.getName());
        movieToUpdate.setCategoryEnum(movie.getCategoryEnum());

        return movieToUpdate;
    }

    public List<MovieModel> addMovie (MovieModel add) {
        if (add.getName() == "") {
            return null;
        }

        this.movies.add(add);

        return this.movies;
    }
    public MovieModel getMovie(Long movieId) {
        for (MovieModel movie : this.movies) {
            if (movie.getId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }
    public boolean removeMovie(Long id){
        return this.movies.removeIf(e -> e.getId().equals(id));
    }
}





