package lut.l09;

import java.util.ArrayList;

public class SavedData {
    static ArrayList<Theatre> arrTheatres = new ArrayList<>();
    static ArrayList<ListedShow> arrShows = new ArrayList<>();

    public static void addTheatre(Theatre theatre) {
        arrTheatres.add(theatre);
    }

    public static void addMovie(ListedShow show) {
        arrShows.add(show);
    }
}

