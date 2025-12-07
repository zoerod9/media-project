public class TVShow extends Media {
    private String director;
    private String country;
    private String rating;
    private int seasons;
    private String description;

    public TVShow(String id, String title, String director, String country,
                  int releaseYear, String rating, int seasons, String description) {
        super(id, title, releaseYear);
        this.director = director;
        this.country = country;
        this.rating = rating;
        this.seasons = seasons;
        this.description = description;
    }

    public String getRating() { return rating; }
    @Override
    public String toString() {
        return "TVShow{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", releaseYear=" + releaseYear + '}';
    }
}
