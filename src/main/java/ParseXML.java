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
    public List<Item> parse(String fileAddress) throws ParserConfigurationException, SAXException, IOException {
        List<Item> itemList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        DefaultHandler handler = new DefaultHandler() {
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
        };
        parser.parse(new File(fileAddress), handler);
        //System.out.println(itemList);

        return itemList;
    }
}
