import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main {
    static ScanAddress scanAddress = new ScanAddress();
    static Parse parse;
    static Analysis analysis = new Analysis();

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        String entryStr;
        Scanner console = new Scanner(System.in);
        System.out.println("\n Начало работы парсера");
        while (true) {
            System.out.println("Чтобы распарсить файл, введите его путь");
            System.out.println("Чтобы выйти из приложения, введите 'exit'");
            System.out.print("Ввод: ");
            entryStr = console.nextLine();

            if (entryStr.equalsIgnoreCase("exit")){
                System.out.println("\n Конец работы парсера");
                break;
            }

            if (scanAddress.isFile(entryStr)) {
                if (scanAddress.isCSV(entryStr)) {
                    parse = new ParseCSV();
                    analysis.duplicate(parse.parseFull(entryStr));
                    analysis.showFloor(parse.parseHalf(entryStr));
                }
                else if (scanAddress.isXML(entryStr)) {
                    parse = new ParseXML();
                    analysis.duplicate(parse.parseFull(entryStr));
                    analysis.showFloor(parse.parseHalf(entryStr));
                } else {
                    System.out.println("\nНеверный формат файла. \nУкажите файл с расширением CSV или XML\n");
                }
            }
        }
    }
}
