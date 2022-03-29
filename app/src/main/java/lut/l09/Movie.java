package lut.l09;

public class Movie {
    // Movie info
    private String sName = "MovieName";

    // Show start date & time.
    private int iShowYear = 2001;
    private int iShowMonth = 1;
    private int iShowDay = 1;
    private int iShowHour = 0;
    private int iShowMinute = 0;

    // Constructors
    public Movie() {
        sName = "MovieName";
        iShowYear = 2001;
        iShowMonth = 1;
        iShowDay = 1;
        iShowHour = 0;
        iShowMinute = 0;
    }

    public Movie(
        String sName,
        int iShowYear,
        int iShowMonth,
        int iShowDay,
        int iShowHour,
        int iShowMinute)
    {
        this.sName = sName;
        this.iShowYear = iShowYear;
        this.iShowMonth = iShowMonth;
        this.iShowDay = iShowDay;
        this.iShowHour = iShowHour;
        this.iShowMinute = iShowMinute;
    }

    public Movie setName(String sName) {
        this.sName = sName;
        return this;
    }

    public Movie setShowYear(int iShowYear) {
        this.iShowYear = iShowYear;
        return this;
    }

    public Movie setShowMonth(int iShowMonth) {
        this.iShowMonth = iShowMonth;
        return this;
    }

    public Movie setShowDay(int iShowDay) {
        this.iShowDay = iShowDay;
        return this;
    }

    public Movie setShowHour(int iShowHour) {
        this.iShowHour = iShowHour;
        return this;
    }

    public Movie setShowMinute(int iShowMinute) {
        this.iShowMinute = iShowMinute;
        return this;
    }

//    public String getShowDateAsString() {
//        String sDate = String.format("%#d.%#d.%####d",);
//        return sDate;
//    }
}
