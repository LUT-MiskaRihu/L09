package lut.l09;

import java.util.ArrayList;

public class SavedData {
    static ArrayList<Theatre> arrTheatres = new ArrayList<>();
    static ArrayList<Show> arrShows = new ArrayList<>();

    public static void addTheatre(Theatre theatre) {
        arrTheatres.add(theatre);
    }

    public static void addMovie(Show show) {
        arrShows.add(show);
    }
}

