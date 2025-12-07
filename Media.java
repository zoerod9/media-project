public abstract class Media {
    protected String id;
    protected String title;
    protected int releaseYear;

    public Media(String id, String title, int releaseYear) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getReleaseYear() { return releaseYear; }
}
