import java.io.IOException;
import java.util.Scanner;

public class Main {
    static ScanAddress scanAddress = new ScanAddress();
    static ParseCSV parseCSV = new ParseCSV();
    public static void main(String[] args) throws IOException {
        boolean isRun  = true;
        String entry_str = "";
        Scanner console = new Scanner(System.in);
        System.out.println("\n Начало работы парсера");
        while (isRun) {
            System.out.println("Чтобы выйти из приложения, введите 'exit'");
            System.out.println("Чтобы пропарсить файл, введите его путь");
            System.out.print("Ввод: ");
            entry_str = console.nextLine();

            if (entry_str.equals("exit")){
                isRun = false;
                System.out.println("\n Конец работы парсера");
                break;
            }
            scanAddress.scanAddress(entry_str);
            parseCSV.parse(entry_str);
        }
    }
}
