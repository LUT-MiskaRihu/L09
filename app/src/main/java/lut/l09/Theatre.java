package lut.l09;

import java.util.ArrayList;

public class Theatre {
    private int iID = 0;
    private String sName = "AreaName";
    private ArrayList<Movie> arrMovies = new ArrayList<Movie>();

    public Theatre(int iID, String sName) {
        this.iID = iID;
        this.sName = sName;
    }

    public int getID() {
        return iID;
    }

    public void setID(int iID) {
        this.iID = iID;
    }

    public String getName() {
        return sName;
    }

    public void setName(String sName) {
        this.sName = sName;
    }

    public ArrayList<Movie> getArrMovies() {
        return arrMovies;
    }
}
