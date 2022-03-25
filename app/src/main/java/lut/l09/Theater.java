package lut.l09;

import java.util.ArrayList;

public class Theater {
    private int iID = 0;
    private String sName = "AreaName";
    private ArrayList<Movie> arrMovies = new ArrayList<Movie>();

    public Theater(int iID, String sName) {
        this.iID = iID;
        this.sName = sName;
    }

    public int getID() {
        return(iID);
    }
}
