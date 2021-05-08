package movie.MovieService.model;

import movie.MovieService.model.category.Category;
import org.springframework.stereotype.Component;

@Component
public class MovieModel {
    private long id;
    private String name;
    private Enum<Category> categoryEnum;

    public MovieModel(long id, String name, Enum<Category> categoryEnum) {
        this.id = id;
        this.name = name;
        this.categoryEnum = categoryEnum;
    }
}
