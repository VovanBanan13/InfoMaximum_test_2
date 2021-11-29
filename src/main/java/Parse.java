import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public interface Parse {
    List<Item> parseFull(String fileName) throws IOException, ParserConfigurationException, SAXException;
    List<Item> parseHalf(String fileName) throws IOException, ParserConfigurationException, SAXException;
}
