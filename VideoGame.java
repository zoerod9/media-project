public class VideoGame extends Media {
    private String platform;
    private String genre;
    private String publisher;
    private double copiesSold;

    public VideoGame(String id, String title, String platform, int releaseYear,
                     String genre, String publisher, double copiesSold) {
        super(id, title, releaseYear);
        this.platform = platform;
        this.genre = genre;
        this.publisher = publisher;
        this.copiesSold = copiesSold;
    }

    public double getCopiesSold() { return copiesSold; }
    @Override
    public String toString() {
        return "VideoGame{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", releaseYear=" + releaseYear + '}';
    }
}
