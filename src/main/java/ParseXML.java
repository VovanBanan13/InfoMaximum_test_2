import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXML {
    static List<Item> itemList = new ArrayList<>();

    public void parse(String fileAddress) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileAddress), handler);

        System.out.println(itemList);
    }

    static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("item")) {
                String city = attributes.getValue("city");
                String street = attributes.getValue("street");
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
    }
}
