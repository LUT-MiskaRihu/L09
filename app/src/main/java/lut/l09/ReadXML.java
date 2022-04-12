package lut.l09;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadXML {
    @SuppressLint("SimpleDateFormat")
    public static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    static ArrayList<Theatre> alTheatres = new ArrayList<Theatre>();
    /* Takes a date string as input,
     * converts it to Calendar object,
     * and returns it.
     * */
    @NonNull
    private static Calendar parseDateTime(String dateTimeString) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateTimeFormatter.parse(dateTimeString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /* Takes XML URL and XML tag name as input,
     * transforms the elements into a NodeList object,
     * and returns the list.
     * */
    private static NodeList getNodesByTagName(String sURL, String sTagName) {
        NodeList nodeList = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(sURL);
            document.getDocumentElement().normalize();
            nodeList = document.getElementsByTagName(sTagName);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return nodeList;
    }

    /* Finds Theaters from the XML file,
     * transforms them into Theatre objects,
     * adds them to an ArrayList,
     * and returns the list.
     * */
    public static ArrayList<Theatre> getTheatres() {
        NodeList nodeList = getNodesByTagName(
                "https://www.finnkino.fi/xml/TheatreAreas",
                "TheatreArea");
        for (int i=0; i< nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element theatreElement = (Element) node;
                Theatre theatre = new Theatre();

                // Get theatre ID from XML and store it inside the theatre object.
                theatre.setID(Integer.parseInt(theatreElement.getElementsByTagName("ID").item(0).getTextContent()));

                // Get theatre/area name from XML and store it inside the theatre object.
                theatre.setName(theatreElement.getElementsByTagName("Name").item(0).getTextContent());

                alTheatres.add(theatre);
            }
        }
        return alTheatres;
    }

    @NonNull
    public static String[] getTheaterNames() {
        ArrayList<String> alNames = new ArrayList<>();
        for (Theatre t : getTheatres()) {
            alNames.add(t.getName());
        }
        return alNames.toArray(new String[alTheatres.size()]);
    }

    @NonNull
    public static String[] getShowsAsString() {
        ArrayList<String> alShows = new ArrayList<>();
        for (ListedShow ls : getShows()) {
            alShows.add(ls.toString());
        }
        return alShows.toArray(new String[alShows.size()]);
    }

    /* Finds Shows from the XML file,
     * transforms them into Show objects,
     * adds them to an ArrayList,
     * and returns the list.
     * */
    @NonNull
    public static ArrayList<ListedShow> getShows() {
        ArrayList<ListedShow> arrShows = new ArrayList<>();
        NodeList nodeList = getNodesByTagName(
                "https://www.finnkino.fi/xml/Schedule",
                "Show");

        for (int i=0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element showElement = (Element) node;
                ListedShow show = new ListedShow();

                String title = showElement.getElementsByTagName("Title").item(0).getTextContent();
                Calendar startDateTime = parseDateTime(showElement.getElementsByTagName("dttmShowStart").item(0).getTextContent());
                Calendar endDateTime = parseDateTime(showElement.getElementsByTagName("dttmShowEnd").item(0).getTextContent());
                int locationID = Integer.parseInt(showElement.getElementsByTagName("TheatreID").item(0).getTextContent());

                show.setTitle(title);
                show.setStartDateTime(startDateTime);
                show.setEndDateTime(endDateTime);
                show.setLocationID(locationID);

                System.out.println(show.toString());
            }
        }

        return arrShows;
    }
}
