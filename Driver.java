public class Driver {
    public static void main(String[] args) {
        String filename = "project1dataset.csv";
        Manager m = new Manager();
        m.loadData(filename);

        System.out.println("Total products: " + m.getTotalProducts());
        System.out.println("Total Movies: " + m.getTotalMovies());
        System.out.println("Total TV Shows: " + m.getTotalTVShows());
        System.out.println("Total Video Games: " + m.getTotalVideoGames());
        System.out.println("Total Music Albums: " + m.getTotalMusicAlbums());

        Media oldest = m.getOldestProduct();
        System.out.println("Oldest product: " + (oldest != null ? (oldest.getTitle() + " (" + oldest.getReleaseYear() + ")") : "None"));

        MusicAlbum topAlbum = m.getMostPopularMusicAlbum();
        System.out.println("Most popular Music Album: " + (topAlbum != null ? (topAlbum.getTitle() + " by " + topAlbum.getArtist() + " (sales: " + topAlbum.getGlobalSales() + ")") : "None"));

        VideoGame topGame = m.getMostPopularVideoGame();
        System.out.println("Most popular Video Game: " + (topGame != null ? (topGame.getTitle() + " (" + topGame.getCopiesSold() + " million)" ) : "None"));

        System.out.println("Most common rating (Movies + TV Shows): " + m.getMostCommonFilmRating());

        Movie shortestMovie = m.getShortestMovie();
        System.out.println("Shortest Movie: " + (shortestMovie != null ? (shortestMovie.getTitle() + " (" + shortestMovie.getDuration() + " min)") : "None"));

        MusicAlbum shortestAlbum = m.getShortestMusicAlbum();
        System.out.println("Shortest Music Album: " + (shortestAlbum != null ? (shortestAlbum.getTitle() + " (" + shortestAlbum.getDuration() + " min)") : "None"));
    }
}
