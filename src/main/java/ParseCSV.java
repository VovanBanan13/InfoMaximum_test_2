import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseCSV {
    public void parse(String fileAddress) throws IOException{
        //BufferedReader reader = new BufferedReader(new FileReader("test.csv"));
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));

        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Item> itemList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            Item item = new Item();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    item.setCity(data);
                else if (index == 1)
                    item.setStreet(data);
                else if (index == 2)
                    item.setHouse(Integer.parseInt(data));
                else if (index == 3)
                    item.setFloor(Integer.parseInt(data));
                else
                    System.out.println("Некорректные данные:" + data);
                index++;
            }
            index = 0;
            itemList.add(item);
        }

        reader.close();

        System.out.println(itemList);
    }
}
