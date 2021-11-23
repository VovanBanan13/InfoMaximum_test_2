import java.util.HashMap;
import java.util.List;

public class Analysis {
    public void duplicate(List<Item> itemList) {
        HashMap<Item, Integer> map = new HashMap<>();
        Integer count;
        for (Item it : itemList) {
            count = map.get(it);
            if (count == null) map.put(it, 1);
            else map.put(it, count + 1);
        }
        System.out.println("Количество записей: " + itemList.size());
        System.out.println("Количество уникальных записей: " + map.size());

        for (Item key : map.keySet()) {
            if (map.get(key) > 1) {
                System.out.println(key + "   ---> " + map.get(key) + " repeat");
            }
        }
    }

    public void showFloor(List<Item> itemList) {
        HashMap<Item, Integer> map = new HashMap<>();
        Integer count;
        for (Item it : itemList) {
            count = map.get(it);
            if (count == null) map.put(it, 1);
            else map.put(it, count + 1);
        }
        System.out.println("Домов в городе: ");
        for (Object key : map.keySet()) {
            System.out.println(key + "   ---> " + map.get(key) + " items");
        }
    }
}
