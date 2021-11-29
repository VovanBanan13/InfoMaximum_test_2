import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseCSV implements Parse {
    public List<Item> parseFull(String fileAddress) throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));

        String line;
        Scanner scanner;
        int index = 0;
        List<Item> itemList = new ArrayList<>();

        reader.readLine();
        while ((line = reader.readLine()) != null) {
            Item item = new Item();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) {item.setCity(data);}
                else if (index == 1) {item.setStreet(data);}
                else if (index == 2) {item.setHouse(Integer.parseInt(data));}
                else if (index == 3) {item.setFloor(Integer.parseInt(data));}
                else {System.out.println("Некорректные данные:" + data);}
                index++;
            }
            index = 0;
            itemList.add(item);
        }
        reader.close();

        return itemList;
    }

    public List<Item> parseHalf(String fileAddress) throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));

        String line;
        Scanner scanner;
        int index = 0;
        List<Item> itemList = new ArrayList<>();

        reader.readLine();
        while ((line = reader.readLine()) != null) {
            Item item = new Item();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) {item.setCity(data);}
                else if (index == 3) {item.setFloor(Integer.parseInt(data));}
                index++;
            }
            index = 0;
            itemList.add(item);
        }
        reader.close();

        return itemList;
    }
}
