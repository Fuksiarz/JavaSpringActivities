package movie.movieService.controller;


import movie.movieService.model.Movie;
import movie.movieService.service.MovieNotFoundException;
import movie.movieService.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieRestController {
//    private MovieService movieService;
//
//    public MovieRestController(MovieService movieService) {
//        this.movieService = movieService;
//    }
//
//
//    @GetMapping()
//    public ResponseEntity<List<Movie>> getMovies() {
//        return ResponseEntity.ok(this.movieService.findAll());
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable Long id) {
//        return ResponseEntity.ok(movieService.findById(id));
//    }
//
//    @PostMapping()
//    public ResponseEntity addMoviee() {
//        Movie movies = this.movieService.addMovie("Nazwa", Category.Horror);
//
//        if (movies == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//        return ResponseEntity.ok().build();
//    }

    private final MovieService movieService;


    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;

    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        try {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movieService.addMovie(movie));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> addMovie(@PathVariable Long id) throws MovieNotFoundException {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            movieService.deleteMovieById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/movies/{id}/can")
    public ResponseEntity<Void> isAvailable(@PathVariable Long id){
        movieService.isAvailable(id);
        return ResponseEntity.ok().build();
    }

}






