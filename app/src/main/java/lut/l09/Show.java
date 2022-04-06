package lut.l09;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Show {

    // Attribute(s)
    private String sTitle;
    private LocalDateTime ldtStartDateTime;
    private LocalDateTime ldtEndDateTime;
    private int iLocationID;

    // Constructor(s)
    public Show() {
        this.sTitle = null;
        this.ldtStartDateTime = null;
        this.ldtEndDateTime = null;
        this.iLocationID = 0;
    }

    public String getTitle() {
        return sTitle;
    }

    public void setTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public LocalDateTime getShowStartDateTime() {
        return ldtStartDateTime;
    }

    public void setStartDateTime(LocalDateTime ldtShowStart) {
        this.ldtStartDateTime = ldtShowStart;
    }

    public LocalDateTime getShowEndDateTime() {
        return ldtEndDateTime;
    }

    public void setEndDateTime(LocalDateTime ldtEndDateTime) {
        this.ldtEndDateTime = ldtEndDateTime;
    }

    public int getLocation() {
        return iLocationID;
    }

    public void setLocation(int iLocationID) {
        this.iLocationID = iLocationID;
    }

    @SuppressLint("DefaultLocale")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String toString() {
        String sDate = ldtStartDateTime.format(DateTimeFormatter.ofPattern("%02d.%02d.%04d"));
        String sStartTime = ldtStartDateTime.format(DateTimeFormatter.ofPattern("02d:%02d"));
        String sEndTime = ldtEndDateTime.format(DateTimeFormatter.ofPattern("02d:%02d"));
        String sString = "";
        sString = sString + "Title: %s\n\t";
        sString = sString + "Date: %s\n\t";
        sString = sString + "Start Time: %s\n\t";
        sString = sString + "End Time: %02d:%02d\n\t";
        sString = sString + "Location: %d\n";
        sString = String.format(sString, sTitle, sDate, sStartTime, sEndTime, iLocationID);
        return sString;
    }
}
