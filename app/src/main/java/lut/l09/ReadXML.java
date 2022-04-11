package lut.l09;

import android.os.Build;
import androidx.annotation.RequiresApi;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadXML {
    static ArrayList<Theatre> alTheatres = new ArrayList<Theatre>();

    /* Takes a date string as input,
     * converts it to LocalDateTime object,
     * and returns it.
     * */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static LocalDateTime parseDateTime(String sDateTime) {
        final String sFormat = "yyyy-MM-dd'T'HH:mm:ss"; // DateTime format
        return(LocalDateTime.parse(
                sDateTime,
                DateTimeFormatter.ofPattern(sFormat)
        ));
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

    public static String[] getTheaterNames() {
        ArrayList<String> alNames = new ArrayList<>();
        for (Theatre t : alTheatres) {
            alNames.add(t.getName());
        }
        return alNames.toArray(new String[alTheatres.size()]);
    }

    /* Finds Shows from the XML file,
     * transforms them into Show objects,
     * adds them to an ArrayList,
     * and returns the list.
     * */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<Show> getShows() {
        ArrayList<Show> arrShows = new ArrayList<Show>();
        NodeList nodeList = getNodesByTagName(
                "https://www.finnkino.fi/xml/Schedule",
                "Show");

        for (int i=0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element showElement = (Element) node;
                ListedShow show = new ListedShow();

                String sTitle = showElement.getElementsByTagName("Title").item(0).getTextContent();
                LocalDateTime ldtStartDateTime = parseDateTime(showElement.getElementsByTagName("dttmShowStart").item(0).getTextContent());
                LocalDateTime ldtEndDateTime = parseDateTime(showElement.getElementsByTagName("dttmShowEnd").item(0).getTextContent());
                int iLocation = Integer.parseInt(showElement.getElementsByTagName("TheatreID").item(0).getTextContent());

                show.setTitle(sTitle);
                show.setStartDateTime(ldtStartDateTime);
                show.setEndDateTime(ldtEndDateTime);
                show.setLocation(iLocation);

                System.out.println(show.toString());
            }
        }

        return arrShows;
    }
}
