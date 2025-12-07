public class MusicAlbum extends Media {
    private String artist;
    private double globalSales;
    private int tracks;
    private double duration;
    private String genre;

    public MusicAlbum(String id, int releaseYear, String artist, String title,
                      double globalSales, int tracks, double duration, String genre) {
        super(id, title, releaseYear);
        this.artist = artist;
        this.globalSales = globalSales;
        this.tracks = tracks;
        this.duration = duration;
        this.genre = genre;
    }

    public String getArtist() { return artist; }
    public double getGlobalSales() { return globalSales; }
    public double getDuration() { return duration; }
    @Override
    public String toString() {
        return "MusicAlbum{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", releaseYear=" + releaseYear + '}';
    }
}
