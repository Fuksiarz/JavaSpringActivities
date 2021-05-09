package movie.MovieService.controller;

import movie.MovieService.MovieService;
import movie.MovieService.model.MovieModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public ResponseEntity<List<MovieModel>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


    @PostMapping("/movies")
    public ResponseEntity<MovieModel> addMovie(@RequestBody MovieModel movie){

        List<MovieModel> movies = this.movieService.addMovie(movie);

        if(movies == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> updateMovie(@RequestBody MovieModel movieToUpdate){
        MovieModel movie = this.movieService.updateMovie(movieToUpdate);

        if(movie == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        boolean isRemoved = this.movieService.removeMovie(id);
        if(isRemoved) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}


