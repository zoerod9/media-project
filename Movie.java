public class Movie extends Media {
    private String director;
    private String country;
    private String rating;
    private int duration;
    private String description;

    public Movie(String id, String title, String director, String country,
                 int releaseYear, String rating, int duration, String description) {
        super(id, title, releaseYear);
        this.director = director;
        this.country = country;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
    }

    public int getDuration() { return duration; }
    public String getRating() { return rating; }
    @Override
    public String toString() {
        return "Movie{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", releaseYear=" + releaseYear + '}';
    }
}
