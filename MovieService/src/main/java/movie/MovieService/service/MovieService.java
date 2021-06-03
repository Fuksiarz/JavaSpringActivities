package movie.movieService.service;

import movie.movieService.MovieRepository;
import movie.movieService.model.Movie;
import movie.movieService.model.category.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MovieService {

    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id) {

        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public Movie updateMovie(Long id, Movie movie) {
        var movieToUpdate = getMovieById(id);
        if (movie.getTitle() != null) {
            movieToUpdate.setTitle((movie.getTitle()));
        }
        if (movie.getCategory() != null) {
            movieToUpdate.setCategory(movie.getCategory());
        }

        return addMovie(movieToUpdate);
    }

    public void deleteMovieById(Long id) {
        if (!movieRepository.findAll().removeIf(movie -> movie.getId().equals(id))) {
            movieRepository.deleteById(id);
        }

    }
    public void isAvailable(Long id) {
        var movie = getMovieById(id);
        movie.setAvailable(true);
        addMovie(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }



}







