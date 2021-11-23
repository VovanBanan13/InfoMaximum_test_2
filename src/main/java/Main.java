import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {
    static ScanAddress scanAddress = new ScanAddress();
    static ParseCSV parseCSV = new ParseCSV();
    static ParseXML parseXML = new ParseXML();

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        boolean isRun  = true;
        String entry_str = "";
        Scanner console = new Scanner(System.in);
        System.out.println("\n Начало работы парсера");
        while (isRun) {
            System.out.println("Чтобы выйти из приложения, введите 'exit'");
            System.out.println("Чтобы пропарсить файл, введите его путь");
            System.out.print("Ввод: ");
            entry_str = console.nextLine();

            if (entry_str.equalsIgnoreCase("exit")){
                isRun = false;
                System.out.println("\n Конец работы парсера");
                break;
            }

            if (scanAddress.isFile(entry_str)) {
                if (scanAddress.isCSV(entry_str)) {
                    parseCSV.parse(entry_str);
                }
                else if (scanAddress.isXML(entry_str)) {
                    parseXML.parse(entry_str);
                } else {
                    System.out.println("\nДолжно быть расширение CSV или XML\n");
                }

            }

        }
    }
}
