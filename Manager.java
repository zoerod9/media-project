import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Manager {

    private ArrayList<Media> inventory = new ArrayList<>();

    private int parseIntSafe(String s, int defaultVal) {
        if (s == null) return defaultVal;
        s = s.trim();
        Matcher m = Pattern.compile("(\\d+)").matcher(s);
        if (m.find()) {
            try {
                return Integer.parseInt(m.group(1));
            } catch (NumberFormatException e) {
                return defaultVal;
            }
        }
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return defaultVal;
        }
    }

    public void loadData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String type = data[1];

                switch (type) {
                    case "Movie":
                        inventory.add(new Movie(
                            data[0], data[2], data[3], data[4],
                            parseIntSafe(data[5], 0), data[6],
                            parseIntSafe(data[7], 0), data[8]
                        ));
                        break;

                    case "TV Show":
                        inventory.add(new TVShow(
                            data[0], data[2], data[3], data[4],
                            parseIntSafe(data[5], 0), data[6],
                            parseIntSafe(data[7], 0), data[8]
                        ));
                        break;

                    case "Video Game":
                        inventory.add(new VideoGame(
                            data[0], data[2], data[3],
                            parseIntSafe(data[4], 0), data[5],
                            data[6], Double.parseDouble(data[7])
                        ));
                        break;

                    case "Music Album":
                        inventory.add(new MusicAlbum(
                            data[0], parseIntSafe(data[2], 0), data[3], data[4],
                            Double.parseDouble(data[5]), parseIntSafe(data[6], 0),
                            Double.parseDouble(data[7]), data[8]
                        ));
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

        public int getTotalProducts() { 
        return inventory.size(); 
    }

    public int getTotalMovies() {
        int count = 0;
        for (Media m : inventory) {
            if (m instanceof Movie) {
                count++;
            }
        }
        return count;
    }

    public int getTotalTVShows() {
        int count = 0;
        for (Media m : inventory) {
            if (m instanceof TVShow) {
                count++;
            }
        }
        return count;
    }

    public int getTotalVideoGames() {
        int count = 0;
        for (Media m : inventory) {
            if (m instanceof VideoGame) {
                count++;
            }
        }
        return count;
    }

    public int getTotalMusicAlbums() {
        int count = 0;
        for (Media m : inventory) {
            if (m instanceof MusicAlbum) {
                count++;
            }
        }
        return count;
    }

    public Media getOldestProduct() {
        if (inventory.isEmpty()) return null;

        Media oldest = inventory.get(0);

        for (Media m : inventory) {
            if (m.getReleaseYear() < oldest.getReleaseYear()) {
                oldest = m;
            }
        }

        return oldest;
    }

    public MusicAlbum getMostPopularMusicAlbum() {
        MusicAlbum best = null;

        for (Media m : inventory) {
            if (m instanceof MusicAlbum) {
                MusicAlbum album = (MusicAlbum) m;

                if (best == null || album.getGlobalSales() > best.getGlobalSales()) {
                    best = album;
                }
            }
        }

        return best;
    }

    public VideoGame getMostPopularVideoGame() {
        VideoGame best = null;

        for (Media m : inventory) {
            if (m instanceof VideoGame) {
                VideoGame game = (VideoGame) m;

                if (best == null || game.getCopiesSold() > best.getCopiesSold()) {
                    best = game;
                }
            }
        }

        return best;
    }

    public String getMostCommonFilmRating() {
        HashMap<String, Integer> ratingCount = new HashMap<>();

        for (Media m : inventory) {
            if (m instanceof Movie) {
                Movie mov = (Movie) m;
                String r = mov.getRating();
                ratingCount.put(r, ratingCount.getOrDefault(r, 0) + 1);

            } else if (m instanceof TVShow) {
                TVShow tv = (TVShow) m;
                String r = tv.getRating();
                ratingCount.put(r, ratingCount.getOrDefault(r, 0) + 1);
            }
        }

        // Find the rating with the highest count
        String mostCommon = null;
        int highest = 0;

        for (String key : ratingCount.keySet()) {
            int count = ratingCount.get(key);
            if (count > highest) {
                highest = count;
                mostCommon = key;
            }
        }

        return mostCommon;
    }

    public Movie getShortestMovie() {
        Movie shortest = null;

        for (Media m : inventory) {
            if (m instanceof Movie) {
                Movie mov = (Movie) m;

                if (shortest == null || mov.getDuration() < shortest.getDuration()) {
                    shortest = mov;
                }
            }
        }

        return shortest;
    }

    public MusicAlbum getShortestMusicAlbum() {
        MusicAlbum shortest = null;

        for (Media m : inventory) {
            if (m instanceof MusicAlbum) {
                MusicAlbum alb = (MusicAlbum) m;

                if (shortest == null || alb.getDuration() < shortest.getDuration()) {
                    shortest = alb;
                }
            }
        }

        return shortest;
    }
}