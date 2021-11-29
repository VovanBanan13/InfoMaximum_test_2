import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXML implements Parse {
    private static final String item = "item";

    public List<Item> parseFull(String fileAddress) throws ParserConfigurationException, SAXException, IOException {
        List<Item> itemList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (item.equals(qName)) {
                    String city = new String(attributes.getValue("city").getBytes(StandardCharsets.UTF_8));
                    String street = new String(attributes.getValue("street").getBytes(StandardCharsets.UTF_8));
                    int house = Integer.parseInt(attributes.getValue("house"));
                    int floor = Integer.parseInt(attributes.getValue("floor"));
                    Item item = new Item();
                    item.setCity(city);
                    item.setStreet(street);
                    item.setHouse(house);
                    item.setFloor(floor);
                    itemList.add(item);
                }
            }
        };
        parser.parse(new File(fileAddress), handler);

        return itemList;
    }

    public List<Item> parseHalf(String fileAddress) throws ParserConfigurationException, SAXException, IOException {
        List<Item> itemList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (item.equals(qName)) {
                    String city = new String(attributes.getValue("city").getBytes(StandardCharsets.UTF_8));
                    int floor = Integer.parseInt(attributes.getValue("floor"));
                    Item item = new Item();
                    item.setCity(city);
                    item.setFloor(floor);
                    itemList.add(item);
                }
            }
        };
        parser.parse(new File(fileAddress), handler);

        return itemList;
    }
}
