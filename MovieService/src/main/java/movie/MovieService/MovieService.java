package movie.MovieService;

import movie.MovieService.model.MovieModel;
import movie.MovieService.model.category.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    public final MovieModel movieModel;


    public MovieService(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

    public List<MovieModel> someList(){

        MovieModel movie = new MovieModel(id=0,
                name="teksańska masakra pila mechaniczna",
                categoryEnum= Category.Horror);
        MovieModel movie1 = new MovieModel(id=1,
                name="movie1",
                categoryEnum= Category.History);
        MovieModel movie2 = new MovieModel(id=2,
                name="movie2",
                categoryEnum= Category.Fantasy);

        return List.of( movie,movie1,movie2);

    }


}
