import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {
    static ScanAddress scanAddress = new ScanAddress();
    static ParseCSV parseCSV = new ParseCSV();
    static ParseXML parseXML = new ParseXML();
    static Analysis analysis = new Analysis();

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        String entry_str;
        Scanner console = new Scanner(System.in);
        System.out.println("\n Начало работы парсера");
        while (true) {
            System.out.println("Чтобы пропарсить файл, введите его путь");
            System.out.println("Чтобы выйти из приложения, введите 'exit'");
            System.out.print("Ввод: ");
            entry_str = console.nextLine();

            if (entry_str.equalsIgnoreCase("exit")){
                System.out.println("\n Конец работы парсера");
                break;
            }

            if (scanAddress.isFile(entry_str)) {
                if (scanAddress.isCSV(entry_str)) {
                    analysis.duplicate(parseCSV.parseFull(entry_str));
                    analysis.showFloor(parseCSV.parseHalf(entry_str));
                }
                else if (scanAddress.isXML(entry_str)) {
                    analysis.duplicate(parseXML.parseFull(entry_str));
                    analysis.showFloor(parseXML.parseHalf(entry_str));
                } else {
                    System.out.println("\nДолжно быть расширение CSV или XML\n");
                }
            }
        }
    }
}
