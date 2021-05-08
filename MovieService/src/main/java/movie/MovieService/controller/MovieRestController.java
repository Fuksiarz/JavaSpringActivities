package movie.MovieService.controller;

import movie.MovieService.MovieService;
import movie.MovieService.model.MovieModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/movies")
    public ResponseEntity<List<MovieModel>> getHelloWorld() {


        return ResponseEntity.ok(movieService.someList());
    }

}
