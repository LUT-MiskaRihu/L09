package lut.l09;

import java.util.ArrayList;

public class Theatre {
    private int iID;
    private String sName;
    private ArrayList<Show> arrShows = new ArrayList<Show>();

    public Theatre() {
        this.iID = 0;
        this.sName = "Name";
    }

    public Theatre(int iID, String sName) {
        this.iID = iID;
        this.sName = sName;
    }

    public void setID(int iID) {
        this.iID = iID;
    }

    public void setName(String sName) {
        this.sName = sName;
    }

    public int getID() {
        return iID;
    }

    public String getName() {
        return sName;
    }

    public void addMovie(Show show) {
        arrShows.add(show);
    }

    public ArrayList<Show> getMovies() {
        return arrShows;
    }
}
