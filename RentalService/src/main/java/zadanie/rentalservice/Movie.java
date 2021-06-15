package zadanie.rentalservice;

public class Movie {

    private Long id;

    private String title;

    private Category category;

    private boolean isAvailable = false;

    public Movie(Long id, String title, Category category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.category = category;

        this.isAvailable = isAvailable;
    }


    public Movie() {

    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }


    public void setTitle(String name) {
        this.title = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAvailable(boolean b) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}