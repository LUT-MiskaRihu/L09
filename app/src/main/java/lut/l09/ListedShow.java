package lut.l09;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ListedShow extends Show {
    private Calendar startDateTime;
    private Calendar endDateTime;
    private int locationID;

    public ListedShow() {
        this.title = null;
        this.startDateTime = null;
        this.endDateTime = null;
        this.locationID = 0;
    }

    public Calendar getStartTimeMin() {
        return startDateTime;
    }

    public void setStartDateTime(Calendar startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Calendar getStartTimeMax() {
        return endDateTime;
    }

    public void setEndDateTime(Calendar endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    @SuppressLint("DefaultLocale")
    public String toString() {
        String show;

        show =    "Title:      %s\n"
                + "Date:       %02d.%02d.%04d\n"
                + "Start Time: %02d:%02d\n"
                + "End Time:   %02d:%02d\n"
                + "Location:   %d\n\n";

        show = String.format(
                show,

                this.title,

                // Date
                startDateTime.get(Calendar.DAY_OF_MONTH),
                startDateTime.get(Calendar.MONTH) + 1,
                startDateTime.get(Calendar.YEAR),

                // Start time
                startDateTime.get(Calendar.HOUR),
                startDateTime.get(Calendar.MINUTE),

                // End time
                endDateTime.get(Calendar.HOUR),
                endDateTime.get(Calendar.MINUTE),

                // Location ID
                locationID
        );

        return show;
    }
}
