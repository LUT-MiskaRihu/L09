package lut.l09;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadAndWriteXML {

    public static void getTheaters() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            String sURL = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document document = builder.parse(sURL);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("TheatreArea");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void getShows() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            String sURL = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document document = builder.parse(sURL);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Show");

            for (int i=0; i<nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String sTitle = element.getElementsByTagName("Title").item(0).getTextContent();
                    System.out.println("Title: " + sTitle);

                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            System.out.println("done");
        }
    }
}
